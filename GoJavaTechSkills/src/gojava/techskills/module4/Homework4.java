package gojava.techskills.module4;

/*
Задание 1
 Написать функцию которая считает в консоли до числа Х. Аргументы функции: число Х
 Например Х = 5. Вывод программы: 1 2 3 4 5

Задание 2
 Написать функцию drawRectangle которая рисует в консоли прямоугольник из символов '+'
 Аргументы функции: ширина прямугольника в символах, высота прямоугольника в символах
 Например 3 на 2 Вывод программы:
 + + +
 + + +

Задание 3
Перегрузить функцию drawRectangle (задание 2) таким образом, что бы она могла принимать на вход
только 1 параметр (ширина квадрата) и рисовать квадрат с равными сторонами
Например 2 Вывод программы:
+ +
+ +
Например 3 Вывод программы:
+ + +
+ + +
+ + +

Задание 4
Написать функцию getMax которая принимает на вход два аргумента в виде чисел.
А возврыщает максимальное из этих двух. Так же, необходимо перегрузить эту функцию
для работы с разными числовыми типами переменных (int, float)

Задание 5
Решить задачу 1, без использования циклов. Использовав рекурсию.

Задание 6
Решить задачу 2, без использования циклов. Использовав рекурсию.

Задание 7 (дополнительно)
Написать программу, в которой выполнены все шесть предыдущих заданий.
Каждое задание выполняется в отдельной функции. В пределах этой же функции происходит
ввод с консоли необходимых данных. Программа спрашивает пользователя какую задачу он хочет решить (от 1 до 6).
Затем программа вызывает соответствующую функцию для решения этой задачи. По окончанию решения задачи,
программа спрашивает пользователя, хочет ли он продолжить решать задачи. Если да - опять спрашивает какую задачу.
 */

import gojava.techskills.methods;

public class Homework4 {
    public static void main(String[] args) {
//        countToNumber(askIntNumber());
        drawRectangle(askRectangleSides());
    }

    /**
     * Asks user to enter a whole number.
     * @return Integer number entered by user.
     */
    static int askIntNumber() {
        System.out.print("Enter a whole number: ");
        return methods.getIntInput();
    }

    /**
     * Prints natural numbers from 1 to x.
     * @param x Number to be counted to.
     */
    static void countToNumber(int x) {
        if (x > 0) {
            for (int i = 0; i < x; i++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        }
        else if (x == 0) System.out.println("Ok, just for you i will count to zero:\n0");
        else System.out.println("Sorry, that number is negative, I don't know how to count it.");

    }

    /**
     * Asks user to input two positive integers to be used as sides of a rectangle.
     * @return Array of 2 positive integers.
     */
    static int[] askRectangleSides(){
        int[] sides = new int[2];
        sides[0] = methods.getPositiveIntInput("Enter length of a rectangle.");
        sides[1] = methods.getPositiveIntInput("Enter width of a rectangle.");
        return sides;
    }

    /**
     * Draws a rectangle with '+' signs, length and width defined by an array of 2 positive integers.
     * @param sides Array of 2 positive integers.
     */
    static void drawRectangle(int[] sides) {
        if (sides.length != 2) System.out.println("Wrong input! Must be array of two positive integers!");
        else {
            for (int i = 0; i < sides[0]; i++) {
                for (int j = 0; j < sides[1]; j++) {
                    System.out.print("+ ");
                }
                System.out.println();
            }
        }
    }

    /**
     * Draws a square with '+' signs, length and width defined by an integer.
     * @param side Positive integers.
     */
    static void drawRectangle(int side) {

            for (int i = 0; i < side; i++) {
                for (int j = 0; j < side; j++) {
                    System.out.print("+ ");
                }
                System.out.println();
            }
    }
}
