package gojava.techskills.Offline2;

/*
Задача 0
Написать функцию которая принимает на вход массив чисел.
И возвращает минимальное число (return)

++
Функция находит среднее арифметическое от всех элементов массива. Затем, находит элемент массива который максимально приближен к среднему арифметическому.
Если найдено несколько берем наименьшее.

Пример: {1, 2, 3, 4}  Среднее арифметическое число=2.5 (ответ 2)
*/

import gojava.techskills.methods;

import java.util.Arrays;

public class Task0 {
    public static void main(String[] args) {

        int size = methods.getPositiveIntInput("Enter desired array size.");
        int[] array = methods.getIntsArrayInput(size, "Enter " + size + " int numbers.");
        System.out.println("Array: " + Arrays.toString(array));

        System.out.println("Minimum: " + getMin(array));
        System.out.println("Maximum: " + getMax(array));
        System.out.println("Arithmetic mean (rounded): " + getArithmeticMean(array));
        System.out.println("Array element closest to arithmetic mean: " + closestTo(array));
    }

    /**
     * @param a Array of ints.
     * @return Minimal number found in array.
     */
    public static int getMin(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] < min) min = a[i];
        }
        return min;
    }

    /**
     * @param a Array of ints.
     * @return Maximal number found in array.
     */
    public static int getMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    /**
     * @param a Array of ints.
     * @return Arithmetic mean (rounded down to int).
     */
    public static int getArithmeticMean  (int[] a) {
        int sum = 0;
        for (int number : a) {
            sum += number;
        }
        float exactSum = (float) sum / a.length;
        System.out.println("Arithmetic mean: " + exactSum);
        return sum/a.length;
    }

    /**
     *
     * @param a Array of integers.
     * @return Float arithmetic mean of array.
     */
    public static float getFloatArithmeticMean  (int[] a) {
        int sum = 0;
        for (int number : a) {
            sum += number;
        }
        float exactSum = (float) sum / a.length;
        return exactSum;
    }

    /**
     *
     * @param array Array of integers.
     * @return Element of array closest to arithmetic mean.
     */
    public static int closestTo(int[] array) {
        float mean = getFloatArithmeticMean(array);
        int index = 0;
        float diff = Math.abs(array[0] - mean); //Difference between first element of array and arithmetic mean.
        for (int i = 1; i < array.length; i++) {
            if (diff > Math.abs(array[i] - mean)) { //If found smaller difference (closer to mean)
                diff = Math.abs(array[i] - mean);   // - save it
                index = i;                          // and it's index!
            }

            //When found array element with the same difference from arithmetic mean,
            //check to save index of the element with a lower value.
            else if (diff == Math.abs(array[i] - mean)) {
                index = (array[index] < array[i]) ? index : i;
            }
        }
        return array[index];
    }
}
