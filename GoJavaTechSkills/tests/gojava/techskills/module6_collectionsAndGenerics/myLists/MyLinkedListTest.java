package gojava.techskills.module6_collectionsAndGenerics.myLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList<String> myLinkedListList = new MyLinkedList<>(new String[] {"One", "Two", "Three"});

    @Test
    void add() {
        myLinkedListList.add("Four");
        assertEquals("One Two Three Four", myLinkedListList.toString());
    }

    @Test
    void remove() {
        assertEquals("One Two Three", myLinkedListList.toString());

        myLinkedListList.remove(2);
        myLinkedListList.show();
        assertEquals("One Two", myLinkedListList.toString());
        myLinkedListList.remove(0);
        assertEquals("Two", myLinkedListList.toString());
        myLinkedListList.remove(0);
        assertEquals("", myLinkedListList.toString());
    }

    @Test
    void clear() {
    }

    @Test
    void get() {
    }

    @Test
    void size() {
    }

}