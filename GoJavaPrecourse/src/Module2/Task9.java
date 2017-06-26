package Module2;

/*Дано два числа, вернуть истину если одно из них равняется “10” или их сумма равняется “10”.

makes10(9, 10) → true
makes10(9, 9) → false
makes10(1, 9) → true


public static boolean makes10(int a, int b) {

}
 */

public class Task9 {

    public static void main(String[] args) {
        int n = 1;
        int m = 9;
        System.out.println(makes10(n, m));
    }

    public static boolean makes10(int a, int b) {

        return a == 10 || b == 10 || a + b == 10;
    }
}
