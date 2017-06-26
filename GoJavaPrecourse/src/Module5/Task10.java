package Module5;

/*
Для введённого пользователем с клавиатуры натурального числа посчитайте сумму всех его цифр
(заранее неизвестно сколько цифр будет в числе).
 */

import java.util.Scanner;
public class Task10 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int i = input.nextInt();

        System.out.println("Digit sum of number " + i + " equals " + digitSum(i) + ".");

    }
    private static int digitSum (int n) {

        String number = Integer.toString(n);
        int[] ints = new int[number.length()];
        int sum = 0;

        for (int i = 0; i < number.length(); i++) {
            ints[i] = Integer.parseInt("" + number.charAt(i));
        }

        for (int i = 0; i < ints.length; i++) {
            sum = sum + ints[i];
        }
        return sum;
    }
}
