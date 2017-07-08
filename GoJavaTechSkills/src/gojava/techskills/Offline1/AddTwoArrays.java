package gojava.techskills.Offline1;

/*
Задача 3
Программа считывает размер массива А
Программа считывает массив А
Программа считывает размер миссива B
Программа считывает миссив B

Необходимо просумировать каждый i-тый элемент массива А с каждым i-тым элементом массива B.
Если i-того элемента нет - считать его нулем.

Вывести массив - результат всех сумм.
*/

import java.util.Scanner;
import java.util.Arrays;

public class AddTwoArrays {
    public static void main(String[] args) {


        int[] arrayA = getArrayInput();
        int[] arrayB = getArrayInput();

        System.out.println("Array A:        " + Arrays.toString(arrayA));
        System.out.println("Array B:        " + Arrays.toString(arrayB));
        System.out.println("Sum of A and B: " + Arrays.toString(sumArrays(arrayA, arrayB)));
    }

    static int[] getArrayInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter desired array length.");
        int a = in.nextInt();
        int[] array = new int[a];
        System.out.println("Enter " + a + " numbers separated by Enter.");
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    static int[] sumArrays(int[] a, int[] b) {
        int maxLength, minLength;

        if (a.length >= b.length) {
            maxLength = a.length;
            minLength = b.length;
        }
        else {
            maxLength = b.length;
            minLength = a.length;
        }

        int[] sum = new int[maxLength];
        for (int i = 0; i < minLength; i++) {
            sum[i] = a[i] + b[i];
        }
        if (maxLength != minLength) {
            if (a.length > b.length){
                for (int i = minLength; i < maxLength; i++) {
                    sum[i] = a[i];
                }
            }
            else {
                for (int i = minLength; i < maxLength; i++) {
                    sum[i] = b[i];
                }
            }
        }
        return sum;
    }
}
