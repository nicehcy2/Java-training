package modernjavainaction.chap09;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 의무 체인 패턴(Chain of Responsibility Pattern)
 * 의무 체인 패턴은 요청을 처리할 수 있는 여러 객체들이 체인 형태로 연결되어 있고,
 * 그 중 하나가 요청을 처리하거나 다음 객체로 전달하는 구조의 패턴이다.
 *
 * 요청을 처리할 수 있는 객체를 동적으로 연결해 책임 처리 객체를 유연하게 바꿀 수 있는 구조를 제공
 */
public class ChainOfResponsibilityMain {

    public static void main(String[] args) {

        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);

        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckerProcessing); // 함수 체인(함수 조합), 동작 체인으로 두 함수를 조합한다.
        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result2);
    }

    static abstract class ProcessingObject<T> {
        protected ProcessingObject<T> successor;

        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            T r = handleWork(input); // 현재 단계 처리
            if (successor != null) {
                return successor.handle(r); // 다음 단계로 넘김(다음 처리자가 있다면)
            }
            return r; // 마지막 처리
        }
        abstract protected T handleWork(T input); // 하위 클래스에서 처리 방식 구현
    }

    static class HeaderTextProcessing extends ProcessingObject<String> {
        public String handleWork(String text) {
            return "From Raoul, Mario and Alan: " + text;
        }
    }

    static class SpellCheckerProcessing extends ProcessingObject<String> {
        public String handleWork(String text) {
            return text.replaceAll("labda", "lambda");
        }
    }
}
