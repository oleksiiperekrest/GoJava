package Module6;

/*
Создайте массив из всех нечётных чисел от 1 до 99, выведите его на экран в строку,
а затем этот же массив выведите на экран тоже в строку, но в обратном порядке (99 97 95 93 … 7 5 3 1).
 */

public class Task8 extends IntArrays {
    public static void main(String[] args) {

        int start = 1;
        int finish = 99;

        int[] m = createFilledArray(start, finish,1);

        printArray(m);
        printArrayBackwards(m);

    }
}
