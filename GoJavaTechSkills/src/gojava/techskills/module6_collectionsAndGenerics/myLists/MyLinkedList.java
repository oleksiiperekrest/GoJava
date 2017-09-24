package gojava.techskills.module6_collectionsAndGenerics.myLists;

/**
 * Задание 2 - LinkedList
 * Написать свой класс MyLinkedList как аналог классу LinkedList.
 * Нельзя использовать массив. Каждый элемент должен быть отдельным объектом-посредником(Node - нода)
 * который хранит ссылку на прошлый и следующий элемент коллекции(двусвязный список).
 * Методы
 * add(T value) добавляет элемент в конец
 * remove(int index) удаляет элемент под индексом
 * clear() очищает коллекцию
 * size() возвращает размер коллекции
 * get(int index) возвращает элемент под индексом
 */

public class MyLinkedList<T> {

    private Node<T> first;
    private Node<T> last;

    public MyLinkedList(T[] items) {
        first = new Node<>(items[0], null, null);
        last = first;

        for (int i = 1; i < items.length; i++) {
            add(items[i]);
        }
    }

    public void add(T item) {
        if (first.item == null) {
            last = first = new Node<>(item, null, null);

        } else {
            Node<T> node = new Node<>(item, null, last);
            last.next = node;
            last = node;
        }
    }

    public void remove(int index) {
        if(first == last) {
            clear();
            return;
        }
        Node<T> node = getNode(index);
        final Node<T> next = node.next;
        final Node<T> prev = node.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            node.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            node.next = null;
        }

        node.item = null;
    }

    public void clear() {
        for (Node<T> node = first; node != null; ) {
            Node<T> next = node.next;
            node.item = null;
            node.next = null;
            node.prev = null;
            node = next;
        }
    }

    public void show() {
        Node<T> iterator = first;
        if (iterator.item == null) System.err.println("This collection is empty.");
        else {
            do {
                System.out.print("" + iterator.item + " ");
                iterator = iterator.next;
            } while (iterator != null);
            System.out.println();
        }
    }

    public T get(int index) {
        Node<T> iterator = first;

        if (iterator == null) return null;
        if (index == 0) return first.item;

        while (index > 0) {
            iterator = iterator.next;
            index--;
        }
        return iterator.item;
    }

    private Node<T> getNode(int index) {
        Node<T> iterator = first;

        if (iterator == null) return null;
        if (index == 0) return first;

        while (index > 0) {
            iterator = iterator.next;
            index--;
        }
        return iterator;
    }

    public int size() {
        if (first.item == null) return 0;
        int size = 1;
        Node<T> node = first;
        while (node.next != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    @Override
    public String toString() {
        if (first.item == null) return "";
        StringBuilder stringBuilder = new StringBuilder();
        Node<T> iterator = first;

        do {
            stringBuilder.append("" + iterator.item + " ");
            iterator = iterator.next;
        } while (iterator != null);

        //cutting off last "space" character before returning
        return stringBuilder.toString().substring(0, stringBuilder.length() - 1);
    }
}
