package gojava.techskills.module6_collectionsAndGenerics.myLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapOutputTest {
    private MyHashMap<Integer, String> myHashMap = new MyHashMap<>();


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
    void showEmpty() {
        myHashMap.show();
        assertEquals("The collection is empty\r\n", outContent.toString());
    }

    @Test
    void show() {
        myHashMap.put(1, "One");
        myHashMap.put(2, "Two");
        myHashMap.show();
        assertEquals("2:Two\r\n1:One\r\n", outContent.toString());
    }
}