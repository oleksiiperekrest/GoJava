/*
Создайте программу, выводящую на экран все четырехзначные числа последовательности 1000 1003 1006 1009 1012 1015 ….
 */
public class Task1 {
    public static void main(String[] args) {
        int i = 0;
        int j = 1000;
        do {
            System.out.println(j+i);
            i += 3;
        }
        while ( j+i < 10000);
    }    
}
