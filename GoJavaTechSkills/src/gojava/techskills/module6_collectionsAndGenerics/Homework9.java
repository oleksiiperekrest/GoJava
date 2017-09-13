package gojava.techskills.module6_collectionsAndGenerics;

import gojava.techskills.module6_collectionsAndGenerics.myLists.MyArrayList;

public class Homework9 {
    public static void main(String[] args) {
        MyArrayList<String> myArrayList= new MyArrayList<>(new String[]{});
        myArrayList.add("2");
        System.out.println(myArrayList.get(0) + " " + myArrayList.get(1));
    }
}
