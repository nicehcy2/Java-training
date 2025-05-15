package modernjavainaction.chap06;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {

    // 새로운 결과 컨테이너 만들기
    // 빈 누적자 인스턴스를 만드는 파라미터가 없는 함수
    @Override
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    // 결과 컨테이너에 요소 추가하기
    // 리듀싱 연산을 수행하는 함수를 반환, 스트림 n번째 요소를 탐색할 때 두 인수, 즉 누적자와 n번쨰 요소를 함수에 적용
    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    // 두 결과 컨테이너 병합
    // 스트림의 서로 다른 서브파트를 병렬로 처리할 때 누적자가 이 결과를 어떻게 처리할 지 정의
    @Override
    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    // 최종 변환값을 결과 컨테이너로 적용하기
    // 스트림 탐색을 끝내고 누적자 객체를 최종 결과로 변환하면서 누적 과정을 끝낼 때 호출할 함수를 반환
    @Override
    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    // 컬렉터의 연산을 정의하는 Characteristics 형식의 불변 집합을 반환
    // 스트림을 병렬로 리듀스할 것인지, 그리고 병렬로 리듀스한다면 어떤 최적화를 선택해야 할지 힌트를 제공
    @Override
    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.IDENTITY_FINISH, Characteristics.CONCURRENT
        ));
    }
}
