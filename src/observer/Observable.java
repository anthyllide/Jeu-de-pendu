package observer;

public interface Observable<T> {
    public void addObserver(Observer<T> observer);
    public void notifyObservers(T data) throws InterruptedException;
}
