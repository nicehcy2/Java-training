package modernjavainaction.chap09;

/**
 * 전략 패턴(Strategy Pattern)
 * 한 유형의 알고리즘을 보유한 상태에서 런타임에 적절한 알고리즘을 선택하는 기법
 *
 * 전략 디자인 패턴은 세 부분으로 구성된다.
 * * 알고리즘을 나타내는 인터페이스(Strategy 인터페이스)
 * * 다양한 알고리즘을 나타내는 한 개 이상의 인터페이스 구현(구체적인 구현 클래스)
 * * 전략 객체를 사용하는 한 개 이상의 클라이언트
 */
public class StrategyMain {

    public static void main(String[] args) {

        Validator numericValidator = new Validator(new IsNumeric());
        boolean b1 = numericValidator.validate("aaaa");
        Validator lowerCaseValidator = new Validator(new IsAllLoserCase());
        boolean b2 = lowerCaseValidator.validate("bbbb");

        System.out.println(b1);
        System.out.println(b2);
    }

    interface ValidationStrategy {
        boolean execute(String s);
    }

    static class IsAllLoserCase implements ValidationStrategy {
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    static class IsNumeric implements ValidationStrategy {
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

    static class Validator {
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy v) {
            this.strategy = v;
        }

        public boolean validate(String s) {
            return strategy.execute(s);
        }
    }
}
