/*
В переменной n хранится натуральное двузначное число.
Создайте программу, вычисляющую и выводящую на экран сумму цифр числа n.
*/

public class Task2 {
    public static void main(String[] args) {

        int n = (int) (Math.random() * 91 + 9);

        String q = Integer.toString(n);
        String q1 = "" + q.charAt(0);
        String q2 = "" + q.charAt(1);

        int n1 = Integer.parseInt(q1);
        int n2 = Integer.parseInt(q2);

        System.out.println("Digit sum of number " + n + " is " + (n1+n2) +".");
    }

}
