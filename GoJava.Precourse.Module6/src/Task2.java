/*
Дан массив размерности N,  найти наименьший элемент массива и вывести на консоль
(если наименьших элементов несколько — вывести их все).
 */

public class Task2 extends IntArrays {
    public static void main(String[] args) {
        int n = 20;
        int [] m = new int[n];

        m = randomizeIntArray(m,100);

        printArray(m);

        System.out.println("Minimal values (with indices):");
        for (int i = 0; i < m.length; i++) {
            if (m[i] == getMinValue(m)) {
                System.out.println(m[i] + "(" + i + ")");
            }
        }
    }

    //method returns array filled with randomized ints from 0 to 'maxValue'

}
