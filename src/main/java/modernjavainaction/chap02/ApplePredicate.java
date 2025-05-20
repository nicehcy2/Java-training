package modernjavainaction.chap02;

import modernjavainaction.chap03.Apple;

/**
 * 참 또는 거짓을 반환하는 함수를 프레디케이트
 * 선태 조건을 결정하는 인터페이스
 * 사과의 어떤 속성에 기초해서 불리언 값을 반환해보자
 */
public interface ApplePredicate {

    boolean test(Apple apple);
}
