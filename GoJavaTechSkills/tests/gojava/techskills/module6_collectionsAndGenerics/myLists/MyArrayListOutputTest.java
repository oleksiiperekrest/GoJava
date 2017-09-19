package gojava.techskills.module6_collectionsAndGenerics.myLists;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListOutputTest {

    private MyArrayList<String> myArrayList = new MyArrayList<>(new String[]{"One", "Two"});


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
    void testShow() {
        myArrayList.show();
        assertEquals("One Two\r\n", outContent.toString());
    }

    @Test
    void testShow2() {
        myArrayList.add("Three");
        myArrayList.show();
        assertEquals("One Two Three\r\n", outContent.toString());
    }

    @Test
    void testShowEmpty() {
        myArrayList.clear();
        myArrayList.show();
        assertEquals("List is empty\r\n", errContent.toString());
    }

}