package gojava.techskills.module6_collectionsAndGenerics.myLists;

/**
 * Задание 5 - HashMap
 * Написать свой класс MyHashMap как аналог классу HashMap.
 * Нужно делать с помощью односвязной LLNode.
 * Не может хранить две ноды с одинаковых ключами одновременно.
 * Методы
 * put(T key, K value) добавляет пару ключ + значение
 * remove(T key) удаляет пару по ключу
 * clear() очищает коллекцию
 * size() возвращает размер коллекции
 * get(T key) возвращает значение(K value) по ключу
 */

public class MyHashMap<K, V> {
    private HMNode<K, V> node;
    private int size = 0;

    public void put(K key, V value) {
        if (node == null) {
            node = new HMNode<>(key, value, null);
            size++;
        } else {
            if (this.get(key) != null) {
                System.out.println("Cannot add element to hash map, key is already used!");
            } else {

                this.node = new HMNode<>(key, value, this.node);
                size++;
            }
        }
    }

    public void remove(K key) {
        int count = 0;
        HMNode<K, V> iterator = node;
        HMNode<K, V> bufferedIterator = node;
        do {
            if (iterator.key.equals(key) && iterator.prev == null) {
                bufferedIterator.prev = null;
                size--;
                break;
            } else if (iterator.key.equals(key)) {
                iterator.key = iterator.prev.key;
                iterator.value = iterator.prev.value;
                iterator.prev = iterator.prev.prev;
                size--;
                break;
            }
            bufferedIterator = iterator;
            iterator = iterator.prev;
            count++;

        } while (size != count);
    }

    public void clear() {
        for (HMNode<K, V> n = node; n != null; ) {
            HMNode<K, V> next = n.prev;
            n.key = null;
            n.value = null;
            n = next;
        }
        node = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        HMNode<K, V> valueNode = node;
        if (valueNode == null) return null;
        while (!valueNode.key.equals(key)) {
            if (valueNode.prev == null) return null;
            valueNode = valueNode.prev;
        }
        return valueNode.value;
    }

    public void show() {
        HMNode<K, V> valueNode = node;
        if (valueNode == null) {
            System.out.println("The hash map is empty");
            return;
        }
        do {
            System.out.println(valueNode.key + ":" + valueNode.value);
            valueNode = valueNode.prev;
        } while (valueNode != null);
    }
}


