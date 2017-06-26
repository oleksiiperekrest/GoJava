/*
Создайте программу, вычисляющую факториал натурального числа n, которое пользователь введёт с клавиатуры.
 */
import java.util.Scanner;
public class Task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int i = input.nextInt();
        double j = 1.0;
        for (; i > 1; i--) j = j*i;
        System.out.printf("%.5e", j);
    }
}
