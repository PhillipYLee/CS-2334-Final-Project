public class LinkedListCustom<T> {
    private Node<T> head;
    private int size;
    private static class Node<T> {
        T data;
        Node<T> next;
        Node(T data) { this.data = data; }
    }
    public LinkedListCustom() {
        head = null;
        size = 0;
    }
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) head = newNode;
        else {
            Node<T> current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        size++;
    }
    public void insert(int index, T value) {
        if (index < 0 || index > size) throw new IndexOutOfBoundsException();
        Node<T> newNode = new Node<>(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        Node<T> current = head;
        for (int i = 0; i < index; i++) current = current.next;
        return current.data;
    }
    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        if (index == 0) head = head.next;
        else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) current = current.next;
            current.next = current.next.next;
        }
        size--;
    }
    public int size() {
        return size;
    }
}