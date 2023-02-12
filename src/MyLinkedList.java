import java.util.Arrays;
import java.util.Objects;
public class MyLinkedList <T>{
    private Node first;
    private Node last;

    int size;

    public void add(T element) {
        Node<T> node = new Node<>(element);
        if (first == null) {
            first = node;
            last = first;
        } else {
            last.next = node;
            node.previous = last;
            last = node;
        }
        size++;
    }

    public void remove(int index){
        Objects.checkIndex(index, size);
        Node element = find(index);

        Node second = element.next;
        Node previousNoda = element.previous;

        if(second != null && previousNoda != null) {
            second.setPrevious(element.getPrevious());
            previousNoda.setNext(element.getNext());
        } else if (element == first) {
            first = element.next;
        } else if (second == null){
            element.setPrevious(null);
        }
        size--;
    }

    public void clean() {
        last = null;
        first = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        Node rez = find(index);

        return (T)rez.element;
    }

    @Override
    public String toString() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node rez = first; i < size; rez = rez.next) {
            result[i++] = rez.getElement();
        }
        return Arrays.toString(result);
    }

    private Node find(int index) {
        Objects.checkIndex(index, size);

        Node rez = first;
        for (int i = 0; i < index; i++){
            rez = rez.next;
        }

        return rez;
    }

    private class Node<T> {
        T element;
        Node previous;
        Node next;

        public Node(T element) {
            this.element = element;
        }

        public T getElement() {
            return element;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }



}
