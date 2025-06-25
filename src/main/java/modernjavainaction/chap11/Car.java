package modernjavainaction.chap11;

import java.util.Optional;

public class Car {

    private Optional<Insurance> insurance = Optional.empty();;
    public Optional<Insurance> getInsurance() {
        return insurance;
    }
}
