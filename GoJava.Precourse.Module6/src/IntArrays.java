/*

 */

public class IntArrays {
    public static void main(String[] args) {

    }

    public static void printArray (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void printArrayBackwards (int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[array.length -1 - i] + " ");
        }
    }

    public static int[] randomizeIntArray ( int[] array, int maxValue) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * (maxValue + 1));
        }
        return array;
    }

    public static int getMaxValue (int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if ( array[i] > maxValue ) maxValue = array[i];
        }
        return maxValue;
    }

    public static int getMaxIndex (int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == getMaxValue(array)) {
                index = i;
                break;
            }
        }
        return index;
    }


    public static int getMinValue (int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if ( array[i] < minValue ) minValue = array[i];
        }
        return minValue;
    }

    public static int getMinIndex (int[] array) {
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == getMinValue(array)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int[] switchMinMax (int[] array) {
        int temp = array[getMaxIndex(array)];
        array[getMaxIndex(array)] = array[getMinIndex(array)];
        array[getMinIndex(array)] = temp;

        return array;
    }

    public static int getArraySum (int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = sum + array[i];
        }
        return sum;
    }

    public static double getArithmeticMean (int[] array) {
        return getArraySum(array) / array.length;
    }

    public static int[] switchPlaces (int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;

        return array;
    }

    public static int[] createFilledArray (int start, int finish, int step) {
        int[] m = new int[(finish - start) / step + 1];

        for (int i = 0; i < m.length; i++) {
            m[i] = start + i*step;
        }
        return m;
    }

    public static void swap (int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static int[] sortSelection (int[] a) {
        int[] array = a.clone();
        for (int min = 0; min < array.length - 1; min++) {
            int least = min;

            for (int i = min + 1; i < array.length; i++) {
                if (array[i] < array[least]) {
                    least = i;
                }
            }
            swap(array, min, least);
        }
        return array;
    }

    public static int[] sortBubble (int[] a) {
        int[] array = a.clone();
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j-1] > array[j]) {
                    swap(array, j, j-1);
                }
            }
        }
        return array;
    }

    public static double findMedian (int[] array) {
        array = sortSelection(array);
        double median;
        if (array.length % 2 == 0) {
            median = ( array[array.length / 2] + array[array.length / 2 - 1] ) / 2.0;
        }
        else
            median = array[array.length / 2];
        return median;
    }



}
