package gojava.techskills.module6_collectionsAndGenerics.myLists;


import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Задание 1 - ArrayList
 Написать свой класс MyArrayList как аналог классу ArrayList.
 Можно использовать 1 массив для хранения данных.
 Методы
 add(T value) добавляет элемент в конец
 remove(int index) удаляет элемент под индексом
 clear() очищает коллекцию
 size() возвращает размер коллекции
 get(int index) возвращает элемент под индексом
 */
public class MyArrayList<T> implements List {

    T[] array;

    public MyArrayList(T[] array) {
        this.array = array;
    }

    @Override
    public int size() {
        int size = 0;
        for (T t : array) {
            if (t != null) size++;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean add(Object o) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size(); i++) {
            array[i] = null;
        }
    }

    @Override
    public Object get(int index) {
        return array[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }
}
