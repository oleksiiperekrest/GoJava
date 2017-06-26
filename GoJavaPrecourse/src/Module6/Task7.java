package Module6;

/*
Создайте массив из всех чётных чисел от 2 до 30 и выведите элементы массива на экран.
 */

public class Task7 extends IntArrays{
    public static void main(String[] args) {

        int start = 2;
        int finish = 30;

        int[] m = createFilledArray(start, finish, 2);
        printArray(m);
    }
}
