package Module5;

/*
Создайте программу, выводящую на экран 12 первых элементов последовательности 2a˅(n-2) – 2, где a1=3 и a2=2.
 */
public class Task8 {
    public static void main(String[] args) {
        int aOdd=3,aEven=2;
        System.out.print(aOdd+" "+aEven+" ");
        for (int i=3; i<=12; i++) {
            if (i%2!=0) {
                aOdd= 2 * aOdd - 2;
                System.out.print(aOdd+" ");
            }
            else {
                aEven= 2 * aEven - 2;
                System.out.print(aEven+" ");
            }

        }
    }
}

