package gojava.techskills.module6_collectionsAndGenerics.myLists;

/**
 * Задание 4 - Stack
 Написать свой класс MyStack как аналог классу Stack.
 LIFO (last-in-first-out)
 Можно делать либо с помощью LLNode либо с помощью массива.
 Методы
 push(T value) добавляет элемент в конец
 remove(int index) удаляет элемент под индексом
 clear() очищает коллекцию
 size() возвращает размер коллекции
 peek() возвращает первый элемент в стеке (LIFO)
 pop() возвращает первый элемент в стеке и удаляет его из коллекции
 */

public class MyStack<T> {
    LLNode<T> first;
    LLNode<T> last;
    private int size = 0;

    public MyStack(T[] items) {
        first = new LLNode<>(items[0], null, null);
        last = first;

        for (int i = 1; i < items.length; i++) {
            add(items[i]);
        }
    }

    public MyStack() {
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
        return (first == null) ? null : last.item;
    }

    public T pop(){
        T x;
        x = peek();
        if (x!= null){
            if (last.prev!=null){
                last.prev.next = null;
                last = last.prev;
            }
            else {first = null;
                last = null;
            }
        }
        return x;
    }

    public void show() {
        LLNode<T> iterator = first;
        if (iterator == null) {
            System.out.println("This stack is empty.");
            return;
        }

        do {
            System.out.print(iterator.item + " ");
            iterator = iterator.next;
        } while (iterator != null);
        System.out.println();
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
}
