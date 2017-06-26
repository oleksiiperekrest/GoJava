package Module6;

/*
В массиве из задания 2. найти наибольший элемент.
 */

public class Task3 extends IntArrays {
    public static void main(String[] args) {
        int n = 14;
        int [] m = new int[n];

        m = randomizeIntArray(m,100);

        printArray(m);

        System.out.println("Maximum: " + getMaxValue(m));

    }


}
