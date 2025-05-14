package modernjavainaction.chap05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class MakingStream {

    public static void main(String[] args) {

        System.out.println("값으로 스트림 만들기");
        Stream<String> stream = Stream.of("Modern", "Java", "In", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        System.out.println("배열로 스트림 만들기");
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        System.out.println("파일로 스트림 만들기");
        long uniqueWords = 0;
        try(Stream<String> lines =
                    Files.lines(Paths.get("data.txt"), Charset.defaultCharset())) {

            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();

        } catch (IOException e) {
            System.out.println("파일 입출력 실패");
        }
        System.out.println(uniqueWords);

        System.out.println("iterate로 무한 스트림 만들기");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("퀴즈 5-4");
        Stream.iterate(new long[]{0, 1}, t -> new long[]{t[1], t[0] + t[1]})
                .limit(50)
                .map(t -> t[0])
                .forEach(System.out::println);
    }
}
