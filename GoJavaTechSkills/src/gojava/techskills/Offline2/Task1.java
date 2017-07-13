package gojava.techskills.Offline2;

import java.util.Arrays;

/*
Задача 1
...
 */
public class Task1 {
    public static void main(String[] args) {
        int[] arrayInt = {23, 221, 2, 54, -54, 45, -12, 0, 99};
        float[] arrayFloat = {43.5f, 214.5f, 0f, -34.56f, 23.0f};

//        int[] arrayInt =
        System.out.println(Arrays.toString(arrayInt));
        System.out.println("Maximum: " + findMaxNumber(arrayInt));

        System.out.println(Arrays.toString(arrayFloat));
        System.out.println("Maximum: " + findMaxNumber(arrayFloat));

    }

    /**
     *
     * @param array Array of Integers.
     * @return Index of maximum number.
     */
    public static int findMaxIndex(int[] array) {
        int max = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    /**
     *
     * @param array Array of Floats.
     * @return Index of maximum number.
     */
    public static int findMaxIndex(float[] array) {
        float max = array[0];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
                index = i;
            }
        }
        return index;
    }

    /**
     *
     * @param array Array of Integers.
     * @return Maximum number member of array.
     */
    public static int findMaxNumber(int[] array) {
        return array[findMaxIndex(array)];
    }

    /**
     *
     * @param array Array of Floats.
     * @return Maximum number member of array.
     */
    public static float findMaxNumber(float[] array) {
        return array[findMaxIndex(array)];
    }

}
