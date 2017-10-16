package gojava.techskills.module6_collectionsAndGenerics.myLists;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {
    private MyHashMap<Integer, String> myHashMap = new MyHashMap<>();


    @Test
    void put() {
        myHashMap.put(12, "Twelve");
        assertEquals("Twelve", myHashMap.get(12));
    }

    @Test
    void remove() {
        myHashMap.put(1, "One");
        myHashMap.put(2, "Two");
        myHashMap.put(3, "Three");

        assertEquals("Two", myHashMap.get(2));

        myHashMap.remove(2);

        assertEquals(null, myHashMap.get(2));
    }

    @Test
    void clear() {
        myHashMap.put(1, "One");
        myHashMap.put(2, "Two");
        assertEquals("Two", myHashMap.get(2));

        myHashMap.clear();
        assertEquals(null, myHashMap.get(2));
        assertEquals(null, myHashMap.get(1));
        assertEquals(0, myHashMap.size());

    }

    @Test
    void size() {
        myHashMap.put(1, "One");
        myHashMap.put(2, "Two");
        assertEquals(2, myHashMap.size());

        myHashMap.remove(1);
        assertEquals(1, myHashMap.size());

        myHashMap.clear();
        assertEquals(0, myHashMap.size());
    }
}