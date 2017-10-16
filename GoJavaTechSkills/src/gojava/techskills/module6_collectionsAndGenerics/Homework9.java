package gojava.techskills.module6_collectionsAndGenerics;

import gojava.techskills.module6_collectionsAndGenerics.myLists.*;

public class Homework9 {

    private static MyArrayList<String> myArrayList;
    private static MyLinkedList<Integer> myLinkedList;
    private static MyHashMap<Integer, String> myHashMap;
    private static MyStack<Double> myStack;
    private static MyQueue<Character> myQueue;

    public static void main(String[] args) {
        init();
        showAll();
        addOneToAll();
        showAll();
        showElement();
        removeElement();
        showAll();
        popAndPoll();
        showAll();
        clearAll();
        showAll();
        addOneToAll();
        addOneToAll();
        showAll();
    }

    private static void init() {
        myArrayList = new MyArrayList<>(new String[] {"One", "Two", "Three"});
        myLinkedList = new MyLinkedList<>(new Integer[] {5, 6, 7});
        myHashMap = new MyHashMap<>();
        myHashMap.put(9, "Nine");
        myHashMap.put(10, "Ten");
        myHashMap.put(11, "Eleven");
        myStack =new MyStack<>();
        myStack.add(13.0);
        myStack.add(14.0);
        myStack.add(15.0);
        myQueue = new MyQueue<>();
        myQueue.add('s');
        myQueue.add('e');
        myQueue.add('n');
    }

    private static void showAll() {
        System.out.println("MyArrayList:");
        myArrayList.show();
        System.out.println();
        System.out.println("MyLinkedList:");
        myLinkedList.show();
        System.out.println();
        System.out.println("MyHashMap:");
        myHashMap.show();
        System.out.println();
        System.out.println("MyStack:");
        myStack.show();
        System.out.println();
        System.out.println("MyQueue:");
        myQueue.show();
        System.out.println();
    }

    private static void addOneToAll() {
        System.out.println("Adding 1 element to each collection:");
        System.out.println();
        myArrayList.add("Four");
        myLinkedList.add(8);
        myHashMap.put(12, "Twelve");
        myStack.add(16.0);
        myQueue.add('t');
    }

    private static void showElement() {
        System.out.println("Getting last element of each collection (first from MyQueue):");
        System.out.println();
        System.out.println("MyArrayList:");
        System.out.println(myArrayList.get(myArrayList.size()-1));
        System.out.println();
        System.out.println("MyLinkedList:");
        System.out.println(myLinkedList.get(myLinkedList.size()-1));
        System.out.println();
        System.out.println("MyHashMap:");
        System.out.println(myHashMap.get(12));
        System.out.println();
        System.out.println("MyStack:");
        System.out.println(myStack.peek());
        System.out.println();
        System.out.println("MyQueue:");
        System.out.println(myQueue.peek());
    }

    private static void removeElement() {
        System.out.println("Removing 1 element from each collection:");
        System.out.println();
        myArrayList.remove(1);
        myLinkedList.remove(2);
        myHashMap.remove(10);
        myStack.remove(1);
        myQueue.remove(2);
    }

    private static void popAndPoll() {
        System.out.println("Popping from stack and polling from queue:");
        System.out.println();
        System.out.println("MyStack:");
        System.out.println(myStack.pop());
        System.out.println("MyQueue:");
        System.out.println(myQueue.poll());
        System.out.println();
    }

    private static void clearAll() {
        System.out.println("Clearing all collections:");
        System.out.println();
        myArrayList.clear();
        myLinkedList.clear();
        myHashMap.clear();
        myStack.clear();
        myQueue.clear();
    }
}
