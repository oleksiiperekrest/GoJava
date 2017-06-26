package Module4;

/*Дано целое число. Если число чётное, то к нему прибавить 2, а если нечётное, то 1.
 Не использовать условие "если" (if).
*/

public class Task1 {

    public static void main(String[] args) {

        int n = 46;

        int m = IsEven(n) ? n + 2 : n + 1;

        System.out.println(m);
    }

    public static boolean IsEven(int a) {

        return a % 2 == 0;
    }
}
