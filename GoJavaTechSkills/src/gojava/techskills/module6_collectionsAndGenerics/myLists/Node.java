package gojava.techskills.module6_collectionsAndGenerics.myLists;

public class Node<T> {

    T item;
    Node<T> prev;
    Node<T> next;

    Node(T item, Node<T> next, Node<T> prev) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }
}
