package gojava.techskills.module6_collectionsAndGenerics.myLists;



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
public class MyArrayList<T> {

    private T[] array;

    public MyArrayList(T[] array) {
        this.array = array;
    }

    public void add(T value) {
        Object[] newArray = new Object[array.length+1];
        System.arraycopy(array, 0 , newArray, 0, array.length);
        newArray[newArray.length-1] = value;
        array = (T[]) newArray;
    }

    public void remove(int index) {
        Object[] newArray = new Object[array.length-1];
        if (index == 0) {
            System.arraycopy(array, 1, newArray, 0, newArray.length);
        }
        else {
            System.arraycopy(array, 0, newArray, 0, index);
            System.arraycopy(array, (index+1), newArray, index, (array.length-index-1));
        }
        array = (T[]) newArray;
    }

    public void clear() {
        array = (T[]) new Object[0];
    }

    public int size() {
        return array.length;
    }

    public T get(int index) {
        return array[index];
    }

    @Override
    public String toString() {
        if (array.length == 0) return "";
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < array.length-1; i++) {

            string.append(array[i] + " ");
        }
        string.append(array[array.length-1]);
        return string.toString();
    }

    public void show() {
        if (array.length == 0) {
            System.err.println("List is empty");
        }
        else {
            for (int i = 0; i < array.length - 1; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println(array[array.length - 1]);
        }
    }
}
