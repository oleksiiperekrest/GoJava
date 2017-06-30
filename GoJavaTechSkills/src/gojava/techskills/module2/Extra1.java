package gojava.techskills.module2;

/*
1) Написать программу которая считает 4 числа c клавиатуры и выведет на
экран самое большое из них.
*/


import java.util.Arrays;

import static gojava.techskills.module2.Homework2.getIntInput;

public class Extra1 {
    public static void main(String[] args) {

        int number = 4;
        int[] ints = getArrayInput(number);

        System.out.println(Arrays.toString(ints));
        System.out.println("The largest number is: " + getMaxValue(ints));

    }

    static int[] getArrayInput(int number){
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Please enter a whole number (" + (i + 1) + " of " + number + ").");
            array[i] = getIntInput();
        }
        return array;
    }

    static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) maxValue = array[i];
        }
        return maxValue;
    }
}
