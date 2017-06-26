package Module6;

/*
Найти среднее арифметическое всех элементов массива.
 */

public class Task5 extends IntArrays{
    public static void main(String[] args) {

        int n = 14;
        int [] m = new int[n];

        m = randomizeIntArray(m,100);
        printArray(m);

        System.out.println(getArithmeticMean(m));
    }
}
