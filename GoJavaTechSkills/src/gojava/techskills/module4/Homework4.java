package gojava.techskills.module4;

/*
Задание 1 v
 Написать функцию которая считает в консоли до числа Х. Аргументы функции: число Х
 Например Х = 5. Вывод программы: 1 2 3 4 5

Задание 2 v
 Написать функцию drawRectangle которая рисует в консоли прямоугольник из символов '+'
 Аргументы функции: ширина прямугольника в символах, высота прямоугольника в символах
 Например 3 на 2 Вывод программы:
 + + +
 + + +

Задание 3 v
Перегрузить функцию drawRectangle (задание 2) таким образом, что бы она могла принимать на вход
только 1 параметр (ширина квадрата) и рисовать квадрат с равными сторонами
Например 2 Вывод программы:
+ +
+ +
Например 3 Вывод программы:
+ + +
+ + +
+ + +

Задание 4 v
Написать функцию getMax которая принимает на вход два аргумента в виде чисел.
А возврыщает максимальное из этих двух. Так же, необходимо перегрузить эту функцию
для работы с разными числовыми типами переменных (int, float)

Задание 5 v
Решить задачу 1, без использования циклов. Использовав рекурсию.

Задание 6 v
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

          selectTask();
    }

    /**
     * User menu method for all the methods in this class.
     */
    static void selectTask() {
        System.out.println("I greet you, %username." +
                "\nI am THE MASTER METHOD of this program, I invite you to make a choice.\n");
        boolean repeat = true;
        int userChoice;
        while (repeat) {
            System.out.println("1. Count from 1 to whatever number you wish." +
                    "\n2. Count from 1 to whatever, but with RECURSION magic!" +
                    "\n3. Draw a square with '+' signs size of which you decide." +
                    "\n4. Draw a rectangle with '+' signs with dimensions of your desire." +
                    "\n5. Draw a rectangle like one in (3) but with some inner RECURSIVE mojo." +
                    "\n6. Compare two numbers (int or float) and find out which one is greater." +
                    "\n0. Exit the program.");

            userChoice = methods.getPositiveIntInput("\nPlease, make your choice.");
            switch (userChoice) {
                case 1:
                    countToNumber(askIntNumber());
                    break;
                case 2:
                    countToNumberRecursively(askIntNumber());
                    break;
                case 3:
                    drawRectangle(methods.getPositiveIntInput("Enter side length of a square."));
                    break;
                case 4:
                    drawRectangle(askRectangleSides());
                    break;
                case 5:
                    drawRectangleRecursively();
                    break;
                case 6:
                    compareTwoNumbers();
                    break;
                case 0:
                    System.exit(0);
                    default:
                        System.out.println("Sorry, I didn't get that...");


            }


            if (!methods.yesNo("\nDo you wish to repeat?")) repeat =  false;
        }
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
        } else if (x == 0) System.out.println("Ok, just for you i will count to zero:\n0");
        else System.out.println("Sorry, that number is negative, I don't know how to count it.");
    }

    /**
     * Prints natural numbers from 1 to x.
     * @param x Number to be counted to.
     */
    static void countToNumberRecursively(int x) {
        if (x > 0) {
            if (x == 1) System.out.print("1 ");
            else {
                countToNumberRecursively(x - 1);
                System.out.print(x + " ");

            }
        } else if (x == 0) System.out.println("Ok, just for you i will count to zero:\n0");
        else System.out.println("Sorry, that number is negative, I don't know how to count it.");
    }

    /**
     * Asks user to input two positive integers to be used as sides of a rectangle.
     * @return Array of 2 positive integers.
     */
    static int[] askRectangleSides() {
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
        for (int i = 0; i < sides[0]; i++) {
            for (int j = 0; j < sides[1]; j++) {
                System.out.print("+ ");
            }
            System.out.println();
        }

    }

    /**
     * Control function for drawRectangleRecursively(int height, int width, int resWidth)
     * Asks user input of two positive integers and transfers as 3 arguments for recursive drawing.
     */
    static void drawRectangleRecursively() {
        int a,b;
        a = methods.getPositiveIntInput("Enter height of a rectangle.");
        b = methods.getPositiveIntInput("Enter width of a rectangle.");
        System.out.println("Height = " + a + ", width = " + b + ".");
        drawRectangleRecursively(a, b, b);
        System.out.println();
    }

    /**
     * Draws a rectangle with '+' signs of assigned height and width to console
     * @param height Height (rows count).
     * @param width Width (column count).
     * @param resWidth Reserve width for recursive calls. MUST BE EQUAL TO WIDTH ↑.
     */
    static void drawRectangleRecursively(int height, int width, int resWidth) {
        if (height > 0 || width > 0) {
            if (width > 0) {
                System.out.print("+ ");
                drawRectangleRecursively(height, width - 1, resWidth);
                return;
            }
            if (height > 1) {
                System.out.println();
                drawRectangleRecursively(height - 1, resWidth, resWidth);
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

    /**
     * Gets input of two numbers and calls getMax() to compare them and print out greater of them.
     */
    static void compareTwoNumbers() {
        float floatA = methods.getFloatInput("Enter first number.");
        float floatB = methods.getFloatInput("Enter second number.");
        int intA = (int) floatA, intB = (int) floatB;
        System.out.print("Maximum number is: ");
        if ((floatA % intA != 0) && (floatB % intB != 0)) System.out.println(getMax(floatA, floatB));
        if ((floatA % intA != 0) && !(floatB % intB != 0)) System.out.println(getMax(floatA, intB));
        if (!(floatA % intA != 0) && (floatB % intB != 0)) System.out.println(getMax(intA, floatB));
        if (!(floatA % intA != 0) && !(floatB % intB != 0)) System.out.println(getMax(intA, intB));
    }


    /**
     * @param a Integer number to be compared.
     * @param a Integer number to be compared.
     * @return Greater of two numbers.
     */
    static int getMax(int a, int b) {
        return a >= b ? a : b;
    }

    /**
     * @param a Integer number to be compared.
     * @param a Integer number to be compared.
     * @return Greater of two numbers.
     */
    static float getMax(int a, float b) {
        return a >= b ? a : b;
    }

    /**
     * @param a Integer number to be compared.
     * @param a Integer number to be compared.
     * @return Greater of two numbers.
     */
    static float getMax(float a, int b) {
        return a >= b ? a : b;
    }
    /**
     * @param a Float number to be compared.
     * @param a Float number to be compared.
     * @return Greater of two numbers.
     */
    static float getMax(float a, float b) {
        return a >= b ? a : b;
    }
}
