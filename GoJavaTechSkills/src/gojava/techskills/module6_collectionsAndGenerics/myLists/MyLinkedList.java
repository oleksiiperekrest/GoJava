package gojava.techskills.module6_collectionsAndGenerics.myLists;

/**
 * Задание 2 - LinkedList
 Написать свой класс MyLinkedList как аналог классу LinkedList.
 Нельзя использовать массив. Каждый элемент должен быть отдельным объектом-посредником(Node - нода)
 который хранит ссылку на прошлый и следующий элемент коллекции(двусвязный список).
 Методы
 add(T value) добавляет элемент в конец
 remove(int index) удаляет элемент под индексом
 clear() очищает коллекцию
 size() возвращает размер коллекции
 get(int index) возвращает элемент под индексом
 */

public class MyLinkedList<T> {

    Node<T> first;

    public MyLinkedList(Node<T> first) {
        this.first = first;
    }
}
