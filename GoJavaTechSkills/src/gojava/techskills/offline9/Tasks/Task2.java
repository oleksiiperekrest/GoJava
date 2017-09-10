package gojava.techskills.offline9.Tasks;

/*
Задание 2
Дан файл с json в котором лежит массив целых чисел. Необходимо считать массив и выполнить с ним следующие независимые
действия и по каждому отдельно вывести число - ответ:
Найти сумму всех чисел 1 + 2 + 3 … + N
Перемножить все числа друг на друга 1 * 2 * 3 … * N
Делить каждое число на его индекс в массиве+1, найти сумму всех результатов деления 12 / 1 + 8 / 2 + 20 / 3 + 30 / 4 … x / N  (1,2,3,4 … N - это индексы+1 элемента массива)
Найти разницу всех чисел. 1 - 2 - 3 … - N

Одновременно может выполняться только одна из 4 операций.
Замерьте время выполнения каждой операции отдельно.
Ускорьте время выполнения каждой операции разделив ее логику на потоки.

Подсказка: гугл Thread.join
 */



public class Task2 {

    public static long sum(int[] array) {
        long sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

    public static void printSum(int[] array) {
        System.out.println("Sum of numbers: " + sum(array));
    }

    public static long product(int[] array) {
        long product = 1;
        for (int number : array) {
            product *= number;
        }
        return product;
    }

    public static void printProduct(int[] array){
        System.out.println("Product of numbers: " + Task2.product(array));
    }

    public static long sumNumbersDividedByIndex(int[] array) {
        long sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i] / (i + 1);
        }
        return sum;
    }

    public static void printSumNumbersDividedByIndex(int[] array){
        System.out.println("Sum of numbers divided by their index: " + Task2.sumNumbersDividedByIndex(array));
    }

    public static long difference(int[] array) {
        long diff = array[0];
        for (int i = 1; i < array.length; i++) {
            diff -= array[i];
        }
        return diff;
    }

    public static void printDifference(int[] array){
        System.out.println("Difference of numbers: " + Task2.difference(array));
    }
}
