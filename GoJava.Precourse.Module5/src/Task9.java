/*
Выведите на экран первые 11 членов последовательности Фибоначчи.
Напоминаем, что первый и второй члены последовательности равны единицам, а каждый следующий — сумме двух предыдущих.
 */
public class Task9 {
    public static void main(String[] args) {

        int count = 11;

        fibonacci(count);
    }

    private static void fibonacci (int count){

        int f1 = 1, f2 = 1;

        System.out.print(f1 + " " + f2 + " ");
        for (int i = 0; i < count/2 - 1; i++) {
            f1 = f1 + f2;
            System.out.print(f1 + " ");
            f2 = f1 + f2;
            System.out.print(f2 + " ");
            if ( i == count / 2 - 2 && count % 2 != 0 ) System.out.print(f1 + f2 + " ");
        }
    }
}
