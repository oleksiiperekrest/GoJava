package Module6;

/*
Имеется массив из четырех чисел int[] numbers = {3, 9, 11, 15};.
Поменяйте местами первый и второй элемент массива.
 */

public class Task6 extends IntArrays{
    public static void main(String[] args) {

        int[] numbers = {3, 9, 11, 15};

        printArray(numbers);

        numbers = switchPlaces(numbers, 0, 1);
        printArray(numbers);
    }
}
