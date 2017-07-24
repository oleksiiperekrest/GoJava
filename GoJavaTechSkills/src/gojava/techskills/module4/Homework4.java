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

class Homework4 {
    public static void main(String[] args) {
        selectTask();
    }

    /**
     * User menu method for all the methods in this class.
     */
    private static void selectTask() {
        boolean repeat = true;
        int userChoice;
        String greetingMessage = "I greet you, %username." +
                "\nI am THE MASTER METHOD of this program, I invite you to make a choice.\n";
        String line1 = "1. Count from 1 to whatever number you wish.";
        String line2 = "2. Count from 1 to whatever, but with RECURSION magic!";
        String line3 = "3. Draw a square with '+' signs size of which you decide.";
        String line4 = "4. Draw a rectangle with '+' signs with dimensions of your desire.";
        String line5 = "5. Draw a rectangle like one in (4) but with some inner RECURSIVE mojo.";
        String line6 = "6. Compare two numbers (int or float) and find out which one is greater.";
        String line0 = "0. Exit the program.";

        System.out.println(greetingMessage);
        do {
            System.out.println(line1);
            System.out.println(line2);
            System.out.println(line3);
            System.out.println(line4);
            System.out.println(line5);
            System.out.println(line6);
            System.out.println(line0);

            userChoice = methods.getPositiveIntInput("\nPlease, make your choice.");

            switch (userChoice) {
                case 1:
                    CountToNumber.countToNumber(CountToNumber.askIntNumber());
                    break;
                case 2:
                    CountToNumber.countToNumberRecursively(CountToNumber.askIntNumber());
                    break;
                case 3:
                    DrawRectangle.drawRectangle(methods.getPositiveIntInput("Enter side length of a square."));
                    break;
                case 4:
                    DrawRectangle.drawRectangle(DrawRectangle.askRectangleSides());
                    break;
                case 5:
                    DrawRectangle.drawRectangleRecursively();
                    break;
                case 6:
                    CompareTwoNumbers.compareTwoNumbers();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Sorry, I didn't get that...");
            }
            if (!methods.yesNo("\nDo you wish to repeat?")) repeat = false;
        }
        while (repeat);
    }

}
