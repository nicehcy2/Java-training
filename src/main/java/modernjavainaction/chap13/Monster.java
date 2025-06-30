package modernjavainaction.chap13;

public class Monster implements Rotatable, Moveable, Resizable {

    private int x, y, angle, width, height;

    public Monster() {
        this.x = 0;
        this.y = 0;
        this.angle = 0;
        this.width = 10;
        this.height = 10;
    }

    @Override
    public void setRotationAngle(int angleIndegrees) {
        angle = angleIndegrees;
    }

    @Override
    public int getRotationAngle() {
        return angle;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }

    @Override
    public void draw() {

    }
}
