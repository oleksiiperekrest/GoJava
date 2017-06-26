package Module6;

/*
Создайте массив из 20-ти первых чисел Фибоначчи и выведите его на экран.
Напоминаем, что первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих.
 */
public class Task9 extends IntArrays{
    public static void main(String[] args) {

        int count = 20;

        int[] m = new int[count];

        m = fillFibonacciNumbers(m);
        printArray(m);
    }

    public static int[] fillFibonacciNumbers(int[] array) {

        if (array.length > 0) array[0] = 1;
        if (array.length > 1) array[1] = 1;
        if (array.length > 2) {
            for (int i = 2; i <array.length; i++) {
                array[i] = array[i-1] + array[i-2];
            }
        }
        return array;
    }
}
