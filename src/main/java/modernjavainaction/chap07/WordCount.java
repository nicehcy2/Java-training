package modernjavainaction.chap07;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class WordCount {

    public static final String SENTENCE =
            " Nel   mezzo del cammin  di nostra  vita "
                    + "mi  ritrovai in una  selva oscura"
                    + " che la  dritta via era   smarrita ";

    public static void main(String[] args) {
        System.out.println("Found " + countWordsIteratively(SENTENCE) + " words");
        System.out.println("Found " + countWords(SENTENCE) + " words");

        Stream<Character> stream = IntStream.range(0, SENTENCE.length())
                .mapToObj(SENTENCE::charAt);
        System.out.println("Found " + countWords(stream) + " words");
    }

    private static int countWords(Stream<Character> stream) {
        WordCounter wordCounter = stream.reduce(new WordCounter(0, true),
                WordCounter::accumulate,
                WordCounter::combine);

        return wordCounter.getCounter();
    }

    public static int countWordsIteratively(String s) {
        int counter = 0;
        boolean lastSpace = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            }
            else {
                if (lastSpace) {
                    counter++;
                }
                lastSpace = Character.isWhitespace(c);
            }
        }
        return counter;
    }

    public static int countWords(String s) {
        //Stream<Character> stream = IntStream.range(0, s.length())
        //    .mapToObj(SENTENCE::charAt).parallel();
        Spliterator<Character> spliterator = new WordCounterSpliterator(s);
        Stream<Character> stream = StreamSupport.stream(spliterator, true);

        return countWords(stream);
    }

    private static class WordCounter {
        private final int counter;
        private final boolean lastSpace;

        // 이 객체는 불변이기 때문에, 새로운 상태로 전환할 때는 항상 새 객체를 생성
        public WordCounter(int counter, boolean lastSpace) {
            this.counter = counter;
            this.lastSpace = lastSpace;
        }

        public WordCounter accumulate(Character c) {
            if (Character.isWhitespace(c)) {
                // 공백이고 이전도 공백이면 현재 상태 유지
                // 공백이고 이전은 단어이면 단어가 끝난걸로 판단하여 상태 변경
                return lastSpace ? this : new WordCounter(counter, true);
            } else {
                // 문자가 단어이고 이전이 공백이면 새 단어 시작인걸로 판단하여 counter 증가, 상태 변경
                // 문자가 단어이고 이전이 단어이면 현재 상태 유지
                return lastSpace ? new WordCounter(counter + 1, false) : this;
            }
        }

        public WordCounter combine(WordCounter wordCounter) {
            return new WordCounter(counter + wordCounter.counter, wordCounter.lastSpace);
        }

        public int getCounter() {
            return counter;
        }
    }

    private static class WordCounterSpliterator implements Spliterator<Character> {
        private final String string;
        private int currentChar = 0;

        public WordCounterSpliterator(String string) {
            this.string = string;
        }

        @Override
        public boolean tryAdvance(Consumer<? super Character> action) {
            action.accept(string.charAt(currentChar++)); // 현재 문자를 소비
            return currentChar < string.length(); // 소비할 문자가 남아있으면 true를 반환
        }

        // 반복될 자료구조를 분할하는 로직을 포함
        @Override
        public Spliterator<Character> trySplit() {
            int currentSize = string.length() - currentChar;
            if (currentSize < 10) {
                return null; // 파싱할 문자열을 순차 처리할 수 있으만큼 충분히 작아졌음을 알리는 null을 반환
            }

            for (int splitPos = currentSize / 2 + currentChar;
            splitPos < string.length(); splitPos++) {
                if (Character.isWhitespace(string.charAt(splitPos))) {
                    Spliterator<Character> spliterator =
                            new WordCounterSpliterator(string.substring(currentChar, splitPos));
                    currentChar = splitPos;
                    return spliterator; // 공백을 찾았고 문자열을 분리했으르모 루프를 종료
                }
            }
            return null;
        }

        @Override
        public long estimateSize() {
            return string.length() - currentChar;
        }

        @Override
        public int characteristics() {
            return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
        }
    }
}
