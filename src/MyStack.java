import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Objects;

public class MyStack<T> {
    private final int startSize = 2;
    private Object[] myStack = new Object[startSize];
    int size = 0;

    public void add(T element){
        if (size > myStack.length - 1) {
            Object[] myStackClone = myStack.clone();
            myStack = new Object[myStack.length + 10];
            System.arraycopy(myStackClone, 0, myStack, 0, size);
        }
        myStack[size] = element;
        size++;

    }
    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(myStack, index + 1, myStack, index, size - index - 1);
        size--;
    }

    public void clear(){
        myStack = new Object[startSize];
        size = 0;
    }

    public int size(){
        return size;
    }

    public T peek() {
        return (T)myStack[size];
    }

    public T pop() {
        T result = (T) myStack[size - 1];
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            System.arraycopy(myStack, 0, myStack, 0, size - 1);
            size--;
        }
        return result;
    }

    @Override
    public String toString() {
        Object[] myStaskClone = myStack.clone();
        myStack = new Object[size];
        System.arraycopy(myStaskClone, 0, myStack, 0, size);
        return Arrays.toString(myStack);
    }
}


