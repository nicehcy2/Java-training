package modernjavainaction.chap11;

import java.util.Optional;

public class Person {

    private Optional<Car> car = Optional.empty();

    public Optional<Car> getCar() {
        return car;
    }
}
