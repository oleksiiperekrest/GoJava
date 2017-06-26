package Module2;

/*Дано “int n”, вернуть абсолютную разницу между “n” и “21”, но вернуть удвоенную абсолютную разницу если n больше 21.
diff21(19) → 2 ; diff21(-2) → 23
diff21(10) → 11; diff21(50) → 58
diff21(21) → 0
public static int diff21(int n) {
 }
 */

public class Task7 {

    public static void main(String[] args) {

        int n = 50;

        if(n > 21) {
            System.out.println("Doubled absolute difference between " + n + " and 21 is " + diff21(n) * 2 + ".");
        } else {
            System.out.println("Absolute difference between " + n + " and 21 is " + diff21(n) + ".");
        }

    }

    public static int diff21(int n) {
        int diff = n - 21;
        return Math.abs(diff);
    }
}
