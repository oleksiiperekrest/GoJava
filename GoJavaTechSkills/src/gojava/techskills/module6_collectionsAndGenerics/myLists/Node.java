package gojava.techskills.module6_collectionsAndGenerics.myLists;

public class Node<T> {

    T value;
    Node<T> next;
    Node<T> prev;

    public Node(T value, Node<T> next, Node<T> prev) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
