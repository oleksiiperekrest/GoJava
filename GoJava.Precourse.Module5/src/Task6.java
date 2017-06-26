/*
Выведите на экран все положительные целые делители натурального числа, введенного пользователем с клавиатуры.
 */

import java.util.Scanner;
public class Task6 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int i = input.nextInt();

        dividers(i);
    }

    private static void dividers(int i){
        
        for (int j = i/2; j > 1; j--) {
            if ( i%j == 0) System.out.print(j + " ");
        }
    }
}
