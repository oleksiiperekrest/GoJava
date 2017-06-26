package Module2;

/*В переменной n хранится натуральное трёхзначное число.
Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
 */

public class Task4 {
    public Task4() {
    }

    public static void main(String[] args) {
        int n = 368;
        String nString = Integer.toString(n);
        int[] nArray = new int[nString.length()];

        int nSum;
        for(nSum = 0; nSum < nString.length(); ++nSum) {
            nArray[nSum] = Integer.parseInt("" + nString.charAt(nSum));
        }

        nSum = 0;

        for(int i = 0; i < nString.length(); ++i) {
            nSum += nArray[i];
        }

        System.out.println("Number " + n + " consists of " + nString.length() + " digits, and it's digit sum is " + nSum + ".");
    }
}
