package modernjavainaction.chap11;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class OptionalMain {

    public static void main(String[] args) {

        Optional<Car> optCar = Optional.empty();
        System.out.println("빈 Optional: " + optCar);

        Car car = new Car();
        optCar = Optional.of(car);
        // optCar = Optional.of(null);
        // car가 null이라면 즉시 NullPointer예외 발생, Optional을 사용하지 않았더라면 car 프로퍼티에 접근할 때 발생.
        System.out.println("null이 아닌 값으로 Optional 만들기: " + optCar);

        optCar = Optional.ofNullable(car);
        optCar = Optional.ofNullable(null); // car가 null이면 빈 Optional 객체가 반환
        System.out.println("null값으로 Optional 만들기: " + optCar);

        Person person = new Person();
        System.out.println("flatMap으로 Optional 객체 연결(중첩 Optional 구조 X): " + getNameUsingFlatMap(Optional.of(person)));

        System.out.println("orElse 적용: " + getCarInsuranceName(Optional.of(person)));
    }

    private static Optional<String> getNameUsingFlatMap(Optional<Person> optPerson) {
        return optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName);
    }

    static String getCarInsuranceName(Optional<Person> person) {

        return getNameUsingFlatMap(person)
                .orElse("Unknown");
    }

    static Set<String> getCarInsuranceNames(List<Person> persons) {

        return persons.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optIns -> optIns.map(Insurance::getName))
                .flatMap(Optional::stream)
                .collect(Collectors.toSet());
    }

    private static Insurance findCheapestInsurance(Person person, Car car) {

        return new Insurance();
    }

    static Optional<Insurance> nullSafeFindCheapestInsurance(
            Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findCheapestInsurance(p, c)));
    }
}
