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
    public static void main(String[] args){

        int[][] progressions = {{0,2,4,6,8,10,12}, {1,4,7,10,13}, {1,2,4,8,16,32}, {1,3,9,27}, {1,4,9,16,25},
                {1,8,27,64,125}, {5,6,14,41,105}, {5,6,7,99},
                {6,6}, {12,18,24}, {7,19,37,61}, {1,8,27,64,125}, {5,6,14,41,105,230}, {0,1,9,36,100,225}};



        for (int i = 0; i < progressions.length; i++) {

            System.out.println(Arrays.toString(progressions[i]));
            printProgressionType(checkProgressionType(progressions[i]));

            System.out.println(Arrays.toString(continueProgression(progressions[i])));
            System.out.println();
            }
//debugging area
/*
       int[] array = {5,6,7,99};
        System.out.println(Arrays.toString(array));
        System.out.println();
        printProgressionType(checkProgressionType(array));
        System.out.println(Arrays.toString(continueProgression(array)));
*/



    }

    /**
     * Reads an array of ints.
     *
     *
     * Should be called if(checkArithmeticProgression())
     * @return Common difference of first-order Arithmetic progression or
     * next difference of second-order Arithmetic progression. (Basically same thing).
     */
    static int getArithmeticStep(int[] array) {
        if(checkArithmeticProgression(array)) return array[array.length-1] - array[array.length-2];
        else return 0;
    }

    /**
     * Reads an array of ints.
     *
     * @return true if identified as Geometric progression (first-order).
     */
    static boolean checkGeometricProgression(int[] array) {
        if (array[0] == 0) return false;
        if (array.length < 2){
            System.out.println("Entered progression is too small for analysis");
            return false;
        }
        float step = (float)array[1] / array[0];
        for (int i = 2; i < array.length; i++) {
            if (step != array[i] / array[i-1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Reads an array of ints.
     *
     * @return true if identified as Arithmetic progression (first-order).
     */
    static boolean checkArithmeticProgression(int[] array) {
        if (array.length < 2){
            //System.out.println("Entered progression is too small for analysis");
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

    /**
     * Reads an array of ints.
     *
     *
     * Should be called if(checkGeometricProgression())
     * @return Common ratio of Geometric progression.
     */
    static int getGeometricStep(int[] array) {
        if(checkGeometricProgression(array)) return array[1] / array[0];
        else return 1;
    }


    /**
     * Reads an array of ints.
     *
     * @return Array of differences. Used to identify Arithmetic progression of higher orders.
     */
    static int[] getStepsArray(int[] array) {
        int[] stepsArray = new int[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            stepsArray[i] = array[i+1] - array[i];
        }
        return stepsArray;
    }

    /**
     * Reads an array of ints.
     *
     * @return Type of progression as a short String. (should not to be output to user)
     */
    static String checkProgressionType(int[] array) {
        if (checkGeometricProgression(array)) return "geo";
        else if (checkArithmeticProgression(array)) return "ari";
        else if (checkArithmeticProgression(getStepsArray(array))
                && array.length >= 4) return "2^ari";
        else if (checkArithmeticProgression(getStepsArray(getStepsArray(array)))
                && array.length >= 5) return "3^ari";
        else if (checkArithmeticProgression(getStepsArray(getStepsArray(getStepsArray(array))))
                && array.length >= 6) return "4^ari";

        else return "no prog";
    }

    /**
     * Reads an array of ints.
     *
     * Prints a message for progression type found with checkProgressionType(int[] array).
     */
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

            case "no prog":
                System.out.println("Progression type not found.");
                break;
        }
    }

    /**
     * Reads an array of ints.
     *
     * @return An initial array +1 length supplemented with next member of identified progression.
     */
    static int[] continueProgression(int[] array) {
        if (checkProgressionType(array) == "no prog") return array;
        int[] progressionNext = new int[array.length+1];
        for (int i = 0; i < array.length; i++) {
            progressionNext[i] = array[i];
        }
        progressionNext[array.length] = getNextTerm(array);
        return progressionNext;
    }

    /**
     * Reads an array of ints.
     *
     * @return int next member of Geometric or Arithmetic progression.
     */
    static int getNextTerm(int[] array) {
        if (checkProgressionType(array) == "geo") return array[array.length-1] * getGeometricStep(array);
        else if (checkProgressionType(array) == "ari") return array[array.length-1] + getArithmeticStep(array);
        else if (checkProgressionType(array) == "2^ari" || checkProgressionType(array) == "3^ari" ||
                checkProgressionType(array) == "4^ari") return array[array.length-1] +
                continueProgression(getStepsArray(array))[continueProgression(getStepsArray(array)).length-1];

        else return 0;
    }
}
