package gojava.techskills.module6_collectionsAndGenerics.myLists;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private MyArrayList<String> myArrayList = new MyArrayList<>(new String[]{"One", "Two"});

    @Test
    void testToString() {
        assertEquals("One Two", myArrayList.toString());
    }

    @Test
    void testAdd() {
        myArrayList.add("Three");
        assertEquals("One Two Three", myArrayList.toString());
    }

    @Test
    void testClear() {
        myArrayList.clear();
        assertEquals("", myArrayList.toString());
    }

    @Test
    void testSize() {
        assertEquals(2, myArrayList.size());
        myArrayList.add("Three");
        assertEquals(3, myArrayList.size());
        myArrayList.remove(1);
        assertEquals(2, myArrayList.size());
        myArrayList.clear();
        assertEquals(0, myArrayList.size());
        myArrayList.add("Zero");
        assertEquals(1, myArrayList.size());
    }

    @Test
    void testGet() {
        assertEquals("One", myArrayList.get(0));
        myArrayList = new MyArrayList<>(new String []{"1", "2", "3"});
        assertEquals("3", myArrayList.get(2));
    }



}