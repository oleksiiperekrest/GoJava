package gojava.techskills.module6_collectionsAndGenerics.myLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListOutputTest {

    private MyLinkedList<String> myLinkedListList = new MyLinkedList<>(new String[] {"One", "Two", "Three"});


    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    void cleanUpStreams() {
        System.setOut(null);
        System.setErr(null);
    }

    @Test
    void show() {
        myLinkedListList.show();
        assertEquals("One Two Three \r\n", outContent.toString());
    }

    @Test
    void addShow() {
        myLinkedListList.add("Four");
        myLinkedListList.show();
        assertEquals("One Two Three Four \r\n", outContent.toString());
    }

    @Test
    void removeShow() {
        myLinkedListList.remove(1);
        myLinkedListList.show();
        assertEquals("One Three \r\n", outContent.toString());
    }

    @Test
    void clearShow() {
        myLinkedListList.clear();
        myLinkedListList.show();
        assertEquals("This collection is empty.\r\n", errContent.toString());
    }

}