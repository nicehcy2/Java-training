package modernjavainaction.chap07;

import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {

    static long iterativeSum(long n) {
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .reduce(0L, Long::sum);
    }

    static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1)
                .limit(n)
                .parallel() // 스트림을 병렬 스트림으로 변환
                .reduce(0L, Long::sum);
    }

    static long sideEffectParallelSum(long n) {
        Accumulator accumulator = new Accumulator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumulator::add);
        return accumulator.total;
    }

    public static void main(String[] args) {

        System.out.println("for-each문으로 연산");
        System.out.println(iterativeSum(1000) + "\n");

        System.out.println("순차 스트림으로 리듀싱 연산");
        System.out.println(sequentialSum(1000) + "\n");

        System.out.println("병렬 스트림으로 리듀싱 연산");
        System.out.println(parallelSum(1000) + "\n");
    }

    static class Accumulator {
        public long total = 0;
        public void add(long value) { total += value; }
    }
}
