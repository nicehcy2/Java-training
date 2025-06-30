package modernjavainaction.chap13;

public interface Sized {
    int size();
    default boolean isEmpty() { // 디폴트 메서드
        return size() == 0;
    }
}
