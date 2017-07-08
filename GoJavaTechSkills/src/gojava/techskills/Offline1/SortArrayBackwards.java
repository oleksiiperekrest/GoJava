package gojava.techskills.Offline1;

/*
Задача 4
Программа считывает размер массива А
Программа считывает массив А

Отсортировать массив по убыванию и вывести в консоль
 */
import java.util.Arrays;

import static gojava.techskills.Offline1.ReverseArray.reverseArray;
import static gojava.techskills.module3.Homework3.sortBubble;
import static gojava.techskills.module3.Homework3.getCountedInput;

public class SortArrayBackwards {
    public static void main(String[] args) {

        System.out.println("Sorted in descending order array:\n" +
                Arrays.toString(reverseArray(sortBubble(getCountedInput()))));
    }
}
