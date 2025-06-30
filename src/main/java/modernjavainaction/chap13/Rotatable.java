package modernjavainaction.chap13;

public interface Rotatable {

    void setRotationAngle(int angleIndegrees);
    int getRotationAngle();
    default void rotateBy(int angleIndegrees) {
        setRotationAngle((getRotationAngle() + angleIndegrees) % 360);
    }
}
