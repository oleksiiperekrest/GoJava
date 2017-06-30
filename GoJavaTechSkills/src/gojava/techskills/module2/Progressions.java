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

        printProgressionType(checkProgressionType(array));
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

    static boolean checkGeometricProgression(int[] array) {
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

    static String checkProgressionType(int[] array) {
        if (checkGeometricProgression(array)) return "geo";
        else if (checkArithmeticProgression(array)) return "ari";
        else if (checkArithmeticProgression(getStepsArray(array))) return "2^ari";
        else if (checkArithmeticProgression(getStepsArray(getStepsArray(array)))) return "3^ari";
        else if (checkArithmeticProgression(getStepsArray(getStepsArray(getStepsArray(array))))) return "4^ari";
        else return "no prog";
    }

    static void printProgressionType(String type) {
        switch (type) {
            case "geo":
                System.out.println("It is a geometric progression.");
                break;
            case "ari":
                System.out.println("It is an arithmetic progression.");
                break;
            case "2^ari":
                System.out.println("It is a second-order arithmetic progression.");
                break;
            case "3^ari":
                System.out.println("It is a third-order arithmetic progression.");
                break;
            case "4^ari":
                System.out.println("It is a fourth-order arithmetic progression.");
                break;
        }
    }
}
