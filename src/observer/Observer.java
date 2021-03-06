package observer;

public interface Observer<T> {
    public void update(T data) throws InterruptedException;
}
