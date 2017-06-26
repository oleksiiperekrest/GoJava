/*
 Создайте программу, выводящую на экран первые 20 элементов последовательности 2 4 8 16 32 64 128 ….
 */
public class Task4 {
    public static void main(String[] args) {
        for (int i = 1; i < 21; i++) {
            System.out.print((int)Math.pow(2,i) + " ");
        }
    }
}
