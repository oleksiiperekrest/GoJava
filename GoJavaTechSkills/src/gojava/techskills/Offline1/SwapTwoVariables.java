package gojava.techskills.Offline1;

/*
Задача 1
Пользователь вводит 2 числа.
Программа сохраняет два числа в две переменных.
Первая переменная - А, вторая переменная - B.
Необходимо вывести оба числа, в обратное последовательности.
Но первой на вывод должна идти переменная А, второй - B.
*/
import java.util.Scanner;

public class SwapTwoVariables {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int a = in.nextInt();
        System.out.print("Enter second number: ");
        int b = in.nextInt();

        System.out.println();
        System.out.println("A = " + a + ".\nB = " + b + ".");

        //swap
        int temp = a;
        a = b;
        b = temp;

        System.out.println();
        System.out.println("A = " + a + ".\nB = " + b + ".");

    }

}
