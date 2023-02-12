import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<T> {
    private final static int increaseInSize = 10;
    private final static int startSize = 2;
    private Object[] myArray = new Object[startSize];
    int size;

    public void add(T element){
        if (size > myArray.length - 1) {
            Object[] myArrayClone = myArray.clone();
            myArray = new Object[myArray.length + increaseInSize];
            System.arraycopy(myArrayClone, 0, myArray, 0, size);
        }
        myArray[size] = element;
        size++;
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        System.arraycopy(myArray, index + 1, myArray, index, size - index - 1);
            size--;
    }

    public void clear(){
        myArray = new Object[startSize];
        size = 0;
    }

    public int size(){
        return size;
    }

    public Object get(int index) {
        Objects.checkIndex(index, size);
        return myArray[index];
    }

    @Override
    public String toString() {
        Object[] myArrayClone = new Object[size];
        System.arraycopy(myArray, 0, myArrayClone, 0, size);
        return Arrays.toString(myArrayClone);
    }
}
