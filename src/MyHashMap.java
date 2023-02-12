import java.util.Arrays;
import java.util.Objects;

public class MyHashMap<K,T> {

    Node[] myHashMap = new Node[16];
    int size = 0;

    public void put(K key, T value) {
        int backedIndex = getBackedIndex(key);

        if (myHashMap[backedIndex] == null) {
            myHashMap[backedIndex] = new Node<>(key, value);
            size++;
        } else {
            Node currentNode = myHashMap[backedIndex];

            while (currentNode.getNext() != null) {
                if (isKeyEqual(currentNode, key)) {
                    currentNode.setValue(value);

                    return;
                }

                currentNode = currentNode.getNext();
            }

            currentNode.setNext(new Node<>(key, value));
            size++;
        }
    }
    public boolean remove(K key) {
        int buketIndex = getBackedIndex(key);

        if (myHashMap[buketIndex] == null) {
            return false;
        } else {

            Node previous = myHashMap[buketIndex];
            Node element = myHashMap[buketIndex].next;

            if (isKeyEqual(previous, key)){
                myHashMap[buketIndex] = myHashMap[buketIndex].next;
                size--;
            }
            while (element.getNext() != null) {
                if (isKeyEqual(element, key)) {
                    previous.setNext(element.getNext());
                    size--;
                    return true;
                }
                element = element.getNext();
                previous = previous.getNext();
            }

            if (element.getNext() == null && isKeyEqual(element, key)) {
                previous.setNext(null);
                size--;
            }

        }

        return false;
    }

    public T get(K key) {
        int baketIndex = getBackedIndex(key);
        Node element = myHashMap[baketIndex];
        if (element == null) {
            return null;
        } else {
            while (element != null) {
                if(isKeyEqual(element, key)) {
                    return (T)element.value;
                }
                element = element.next;
            }
        }

        return null;
    }

    public void clear() {
        myHashMap = new Node[16];
        size = 0;
    }

    public int size() {
        return size;
    }

    private boolean isKeyEqual(Node<K,T> node, K key) {
        if (key == null) {
            return node.getKey() == null;
        }

        return (key.hashCode() == node.getHash() && key.equals(node.getKey()));
    }

    private int getBackedIndex(K key) {

        return key.hashCode() % 16;
    }

    private class Node<K, T> {
        T value;
        int hash;
        K key;
        Node next;

        public Node(K key, T value) {
            this.key = key;
            this.value = value;
            hash = key.hashCode();
        }

        public K getKey() {
            return key;
        }

        public T getValuet() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public int getHash() {
            return hash;
        }
    }
}