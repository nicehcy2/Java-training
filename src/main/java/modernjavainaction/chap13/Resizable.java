package modernjavainaction.chap13;

public interface Resizable extends Drawable {
    int getWidth();
    int getHeight();
    void setWidth(int width);
    void setHeight(int height);
    void setAbsoluteSize(int width, int height);
    default void setRelativeSize(int wFactor, int hFactor) { // API 버전 2에 추가된 새로운 메서드
        setAbsoluteSize(getWidth() / wFactor, getHeight() / hFactor);
    }
}
