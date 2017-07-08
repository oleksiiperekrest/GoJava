package gojava.techskills.module3;

/*Задание 1
Создать новый проект на GitHub и на локальном компе Написать программу которая:
1. на вход через консоль принимает размер массива
2. на вход через консоль принимает массив чисел
3. найти минимальное число в массиве и вывести в консоль (без использования сортировки)
4. найти максимальное число в массиве и вывести в консоль (без использования сортировки)
5. посчитать кол-во повторений числа 5 и вывести в консоль
6. вывести в консоль отсортированный массив

Задание 2 (дополнительное)
Добавить к программе из задания 1 следующее:
7. вывести в консоль максимальное кол-во повторений чисел в массиве
пример 1: массив 1, 2, 3, 4, 1, 6.
Ответ 2. Так как число 1 повторяется 2 раза
пример 2: массив 1, 1, 1, 4, 6, 6.
Ответ 3. Так как число 1 повторяется 3 раза. А число 6 повторяется 2 раза. Поскольку надо вывести максимум, выводим 3.
пример 3: массив 2, 3, 3, 5, 5, 6
Ответ 3. Так как 3 и 5 повторяются по 2 раза, не важное кого из них подсчитывать, цель - вывести максимум.
В этом примере максимум повторений чисел является 2 раза.
8. вывести в консоль минимальное кол-во повторений чисел в массиве

Задание 3 (дополнительное)
9. Избавиться от пункта номер один. Массив в программе должен быть создан такого же размера как длинна массива
из консоли (пример: 10, 10, 10, 10 тут размер массива 4; 10, 10 тут размер массива 2)
 */

import java.util.Arrays;
import java.util.Scanner;

public class Homework3 {
    public static void main(String[] args) {

        int[] array = getCountedInput();

        printArrayInfo(array);
    }

    static void printArrayInfo(int[] array) {
        System.out.println(Arrays.toString(array));
        System.out.println("Min value: " + getMinValue(array));
        System.out.println("Max value: " + getMaxValue(array));
        System.out.println("Number 5 found in array " + countFives(array) + " times.");
        System.out.println("Sorted array:\n" + Arrays.toString(sortBubble(array)));
        System.out.println("Maximum repeats in array: " + countMaxRepeats(array) + ".");
    }

    static int[] getCountedInput() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter desired array length.");
        int number = in.nextInt();
        System.out.println("Enter " + number + " integer numbers separated by Enters.");

        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = in.nextInt();
        }
        return array;
    }

    static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if ( array[i] > maxValue ) maxValue = array[i];
        }
        return maxValue;
    }

    static int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) minValue = array[i];
        }
        return minValue;
    }

    static int countFives(int[] array){
        int count = 0;
        for (int number : array) {
            if (number == 5) count++;
        }
        return count;
    }

    static int[] sortBubble (int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j, j - 1);
                }
            }
        }
        return array;
    }

    static void swap (int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    static int countRepeats(int c, int[] array) {
        int count = 0;
        for (int number : array) {
            if (number == c) count++;
        }
        return count;
    }

    static int countMaxRepeats(int[] array) {
        int count = countRepeats(array[0], array);
        for (int i = 1; i < array.length; i++) {
            if (count < countRepeats(array[0], array)) count = countRepeats(array[i], array);
        }
        return count;
    }

}
