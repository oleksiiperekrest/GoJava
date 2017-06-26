package Module5;

/*
Проверьте, входит ли введенное пользователем с клавиатуры натуральное число в диапазон [-10; 10].
 */

import java.util.Scanner;
public class Task7 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int i = input.nextInt();

        withinTens(i);
    }

    private static void withinTens(int i){
        if ( i <= 10 && i >= -10) System.out.println("Number " + i + " is found within range [-10; 10].");
        else System.out.println("Number " + i + " is not found within range [-10; 10].");
    }
}
