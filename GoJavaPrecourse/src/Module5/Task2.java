package Module5;

/*
Создайте программу, выводящую на экран первые 55 элементов последовательности 1 3 5 7 9 11 13 15 17 ….
 */
public class Task2 {
    public static void main(String[] args) {
        for (int i = 0; i < 55; i++) {
            System.out.print(i*2+1 + " ");
        }
    }
}
