package gojava.techskills.module6_collectionsAndGenerics;

import gojava.techskills.module6_collectionsAndGenerics.myLists.MyLinkedList;

import java.util.LinkedList;

public class Homework9 {
    public static void main(String[] args) {
//        MyArrayList<String> myArrayList= new MyArrayList<>(new String[]{"1", "3", "4", "7"});
//        myArrayList.add("2");
//        myArrayList.add("6");
//        System.out.println(myArrayList.get(0) + " " + myArrayList.get(1));
//        myArrayList.show();
//        myArrayList.remove(2);
//        myArrayList.show();
//        myArrayList.remove(4);
//        myArrayList.show();
//        myArrayList.remove(0);
//        myArrayList.show();
//        System.out.println(myArrayList.size());
//        myArrayList.clear();
//        myArrayList.show();
//        System.out.println(myArrayList.size());
//        myArrayList.add("value");
//        myArrayList.add("holo");
//        myArrayList.show();
//        System.out.println(myArrayList.size());
//        System.out.println(myArrayList.toString());
//        System.out.println(new MyArrayList<>(new String[]{"One", "Two"}).toString());

        MyLinkedList<String> myLinkedListList = new MyLinkedList<>(new String[] {"One", "Two", "Three"});

        myLinkedListList.show();
        myLinkedListList.remove(2);
        myLinkedListList.show();
        myLinkedListList.remove(0);
        myLinkedListList.show();
        myLinkedListList.remove(0);
        myLinkedListList.show();

        myLinkedListList.add("String");
        myLinkedListList.add("String");
        myLinkedListList.show();




    }

}
