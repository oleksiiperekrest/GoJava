package gojava.techskills.Offline1;

import java.util.Scanner;
import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter desired array length.");
        int a = in.nextInt();
        int[] array = new int[a];
        System.out.println("Enter " + a + " numbers separated by Enter.");
        for (int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        System.out.println("Initial array:\n" + Arrays.toString(array));
        System.out.println("Reversed array:\n" + Arrays.toString((reverseArray(array))));
    }

    static int[] reverseArray(int[] array){
        int[] reversed = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            reversed[i] = array[array.length-1-i];
        }
        return reversed;
    }

}
