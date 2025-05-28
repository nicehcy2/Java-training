package modernjavainaction.chap07;

import static modernjavainaction.chap07.ParallelStreamsHarness.FORK_JOIN_POOL;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * RecursiveTask를 상속받아 포크/조인 프레임워크에서 사용할 태스트클 생성한다.
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    private final long[] numbers;
    private final int start; // 서브태스크에서 처리할 배열의 초기 위치
    private final int end; // 서브태스크에서 처리할 배열의 최종 위치
    public static final long THRESHOLD = 10_000; // 이 값 이하의 서브태스크는 더 이상 분해할 수 없다.

    // 메인 태스크를 생성할 때 사용할 공개 생성자
    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    // 메인 테스크의 서브태스크를 재귀적으로 만들 때 사용할 비공개 생성자
    private ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    // RecursiveTask의 추상 메서드 오버라이드
    @Override
    protected Long compute() {
        int length = end - start;

        if (length <= THRESHOLD) { // 기준값과 같거나 작으면 순차저으로 결과를 게산
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        leftTask.fork(); // 배열의 첫 번째 절반을 더하도록 서브태스크를 생성
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute(); // 두 번쨰 서브태스크를 동기 실행한다.
        Long leftResult = leftTask.join(); // 첫 번째 서브태스크의 결과를 읽거나 아직 결과가 없으면 기다린다.

        return leftResult + rightResult; // 두 서브태스크의 결과를 조합한 값이 이 태스크의 결과다.
    }

    private long computeSequentially() {
        long sum = 0;
        for (int i=start; i<end; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n) {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return FORK_JOIN_POOL.invoke(task);
    }
}
