package gojava.techskills.module2;

/*Существуют такие последовательности чисел
0,2,4,6,8,10,12
1,4,7,10,13
1,2,4,8,16,32
1,3,9,27
1,4,9,16,25
1,8,27,64,125
Реализуйте программу которая выведет следующий член этой
последовательности (либо подобной им). Например пользователь вводит
строку 0,2,4,6,8,10,12 ответом программы должно быть число 14.
 */

import java.util.Arrays;
public class Progressions {
    public static void main(String[] args) {

        int[] array = {1,8,27,64,125};

        System.out.println(Arrays.toString(array));

        if (checkGeometricProgression(array)) System.out.println("Is Geometric progression!");
        if (checkArithmeticProgression(array)) System.out.println("Is Arithmetic progression!");
        if (checkArithmeticProgression(getStepsArray(array))) System.out.println("Is Second-order Arithmetic progresion!");
        if (checkArithmeticProgression(getStepsArray(getStepsArray(array)))) System.out.println("Is Third-order Arithmetic progresion!");

        System.out.println(Arrays.toString(getStepsArray(array)));
    }

    static int getArithmeticStep(int[] array) {
        if(checkArithmeticProgression(array)) return array[1] - array[0];
        else return 0;
    }

    static boolean checkArithmeticProgression(int[] array) {
        if (array.length < 2){
            System.out.println("Entered progression is too small for analysis");
            return false;
        }
        int step = array[1] - array[0];
        for (int i = 2; i < array.length; i++) {
            if (step != array[i] - array[i-1]) {
                return false;
            }
        }

        return true;
    }

    static int getGeometricStep(int[] array) {
        if(checkGeometricProgression(array)) return array[1] / array[0];
        else return 1;
    }

    static boolean checkGeometricProgression(int[] array){
        if (array.length < 2){
            System.out.println("Entered progression is too small for analysis");
            return false;
        }
        int step = array[1] / array[0];
        for (int i = 2; i < array.length; i++) {
            if (step != array[i] / array[i-1]) {
                return false;
            }
        }
        return true;
    }

    static int[] getStepsArray(int[] array) {
        int[] stepsArray = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            stepsArray[i] = array[i+1] - array[i];
        }
        return stepsArray;
    }
}
