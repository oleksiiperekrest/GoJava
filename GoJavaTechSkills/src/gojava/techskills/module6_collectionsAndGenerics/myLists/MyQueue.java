package gojava.techskills.module6_collectionsAndGenerics.myLists;

/**
 * Задание 3 - Queue
 * Написать свой класс MyQueue как аналог классу Queue и LinkedList.
 * FIFO (first-in-first-out)
 * Можно делать либо с помощью LLNode либо с помощью массива.
 * Методы
 * add(T value) добавляет элемент в конец
 * remove(int index) удаляет элемент под индексом
 * clear() очищает коллекцию
 * size() возвращает размер коллекции
 * peek() возвращает первый элемент в очереди (FIFO)
 * poll() возвращает первый элемент в очереди и удаляет его из коллекции
 */

public class MyQueue<T> {

    LLNode<T> first;
    LLNode<T> last;
    private int size = 0;

    public MyQueue(T[] items) {
        first = new LLNode<T>(items[0], null, null);
        last = first;

        for (int i = 1; i < items.length; i++) {
            add(items[i]);
        }
    }

    public MyQueue() {
    }

    public void add(T item) {

        LLNode<T> l = last;
        LLNode<T> newNode = new LLNode<>(item, null, l);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    public int size() {
        return size;
    }

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public T peek() {
        return (first == null) ? null : first.item;
    }

    public T poll() {
        T x;
        x = peek();
        if (x != null) {
            if (first.next != null) {
                first.next.prev = null;
                first = first.next;
            } else {
                first = null;
                last = null;
            }
        }
        return x;
    }

    public void show() {
        String toString = this.toString();
        if (toString == null) {
            System.out.println("This queue is empty.");
        } else {
            System.out.println(toString);
        }
    }

    public void remove(int index) {
        if(first == last) {
            clear();
            return;
        }
        LLNode<T> node = getNode(index);
        final LLNode<T> next = node.next;
        final LLNode<T> prev = node.prev;

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

    private LLNode<T> getNode(int index) {
        LLNode<T> iterator = first;

        if (iterator == null) return null;
        if (index == 0) return first;

        while (index > 0) {
            iterator = iterator.next;
            index--;
        }
        return iterator;
    }

    @Override
    public String toString() {
        LLNode<T> iterator = first;
        StringBuilder string = new StringBuilder();

        if (iterator == null) return null;

        do {
            string.append(iterator.item + " ");
            iterator = iterator.next;
        } while (iterator != null);

        return string.toString().substring(0, string.length() - 1);
    }
}
