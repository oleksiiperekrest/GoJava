package Module2;

/*Дано два целочисленных значения, вернуть их сумму. Но если они одинаковы, тогда вернуть удвоенную сумму данных чисел.
sum(1, 2) → 3
sum(3, 2) → 5
sum(2, 2) → 8


public static int sum(int a, int b) {
}
 */

public class Task6 {

    public static void main(String[] args) {

        int n = 87;
        int m = 89;

        System.out.println(sum(n, m));
    }

    public static int sum(int a, int b) {

        int sum;
        if(a == b) {
            sum = a * 4;
        } else {
            sum = a + b;
        }
        return sum;
    }
}
