import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue<T> {
    private final int startSize = 2;
    private Object[] myQueue = new Object[startSize];
    int size = 0;

    public void add(T element){
        if (size > myQueue.length - 1) {
            Object[] myQueueClone = myQueue.clone();
            myQueue = new Object[myQueue.length + 10];
            System.arraycopy(myQueueClone, 0, myQueue, 0, size);
        }
        myQueue[size] = element;
        size++;
    }

    public void clear(){
        myQueue = new Object[startSize];
        size = 0;
    }

    public int size(){
        return size;
    }

    public T peek() {
        return (T)myQueue[0];
    }

    public T poll() {
        T result = (T) myQueue[0];
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            System.arraycopy(myQueue, 1, myQueue, 0, size - 1);
            size--;
        }
        return result;
    }

    @Override
    public String toString() {
        Object[] myQueueClone = myQueue.clone();
        myQueue = new Object[size];
        System.arraycopy(myQueueClone, 0, myQueue, 0, size);
        return Arrays.toString(myQueue);
    }
}

