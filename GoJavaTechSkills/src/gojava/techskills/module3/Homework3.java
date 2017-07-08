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

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        int[] array = countedInput() ? getCountedInput() : getUncountedInput();

        printArrayInfo(array);
    }

    /**
     * Prints out array of integers and additional info: min and max value, how many times number 5 found in it,
     * sorted in ascending order array, max and min quantity of repeats of integers in array.
     * @param array Array of integers.
     */
    static void printArrayInfo(int[] array) {
        System.out.println(Arrays.toString(array));
        System.out.println("Min value: " + getMinValue(array));
        System.out.println("Max value: " + getMaxValue(array));
        System.out.println("Number 5 found in array " + countFives(array) + " times.");
        System.out.println("Sorted array:\n" + Arrays.toString(sortBubble(array)));
        System.out.println("Maximum repeats in array: " + countMaxRepeats(array) + ".");
        System.out.println("Minimum repeats in array: " + countMinRepeats(array) + ".");

    }

    /**
     * Asks user for input of array size and integer numbers to fill that array.
     * @return Array of integers entered by user.
     */
    public static int[] getCountedInput() {
        System.out.println("Enter desired array length.");
        int number = in.nextInt();
        System.out.println("Enter " + number + " integer numbers pressing \"Enter\" after each.");

        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            System.out.println("Please enter number " + (i+1) + " of " + number + ".");
            array[i] = in.nextInt();
        }
        return array;
    }

    /**
     * Asks user for input integer numbers to fill an array (arbitrary size).
     * @return Array of integers entered by user.
     */
    static int[] getUncountedInput() {
        System.out.println("Enter integer numbers separated by commas or spaces.");
        String[] lineNumbers;
        int[] numbers;
        while (true) {
            String line = in.nextLine();
            if (line.contains(",")) lineNumbers = line.replaceAll(" ", "")
                    .replaceAll(",+", ",").split(",");

            else lineNumbers = line.replaceAll(" +", " ").split(" ");
            try {
                numbers = new int[lineNumbers.length];
                for (int i = 0; i < lineNumbers.length; i++) {
                    numbers[i] = Integer.parseInt(lineNumbers[i]);
                }
                break;
            }
                catch (Exception e) {
                    System.out.println("Please enter only integer numbers separated by (only) commas or spaces");
                }
            }
        return numbers;
    }

    /**
     * Asks user whether they want to predetermine array size.
     * @return Does user want to enter array size?
     */
    static boolean countedInput() {
        String input;
        boolean yn;

        System.out.println("Would you like to predetermine number of integers in an array? (y/n)");
        while (true) {
            input = in.nextLine().trim().toLowerCase();

            if (input.equals("y")) {
                yn = true;
                break;
            } else if (input.equals("n")) {
                yn = false;
                break;
            } else {
                System.out.println("Please answer \"y\" or \"n\".");
            }
        }
        return yn;
    }

    /**
     * @param array Array of integers.
     * @return Largest integer number of given array.
     */
    static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if ( array[i] > maxValue ) maxValue = array[i];
        }
        return maxValue;
    }

    /**
     * @param array Array of integers.
     * @return Smallest integer number of given array.
     */
    static int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) minValue = array[i];
        }
        return minValue;
    }

    /**
     * @param array Array of integers.
     * @return How many times number 5 found in given array.
     */
    static int countFives(int[] array){
        int count = 0;
        for (int number : array) {
            if (number == 5) count++;
        }
        return count;
    }

    /**
     * @param array Array of integers.
     * @return Array sorted in ascending order with bubble sort algorithm.
     */
    public static int[] sortBubble (int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swap(array, j, (j - 1));
                }
            }
        }
        return array;
    }

    /**
     * @param array Array of integers
     * @param a Index of first element to be swapped with second.
     * @param b Index of second element to be swapped with first.
     */
    public static void swap (int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    /**
     * @param c Integer number to be searched in array.
     * @param array Array of integers.
     * @return How many times given number was found in array.
     */
    static int countRepeats(int c, int[] array) {
        int count = 0;
        for (int number : array) {
            if (number == c) count++;
        }
        return count;
    }

    /**
     * @param array Array of integers.
     * @return Most number of repeated numbers in array.
     */
    static int countMaxRepeats(int[] array) {
        int count = countRepeats(array[0], array);
        for (int i = 1; i < array.length; i++) {
            if (count < countRepeats(array[i], array)) count = countRepeats(array[i], array);
        }
        return count;
    }

    /**
     * @param array Array of integers.
     * @return Least number of repeated numbers in array.
     */
    static int countMinRepeats(int[] array) {
        int count = countRepeats(array[0], array);
        for (int i = 1; i < array.length; i++) {
            if (count > countRepeats(array[i], array)) count = countRepeats(array[i], array);
        }
        return count;
    }
}
