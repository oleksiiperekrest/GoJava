/*
Создать программу, выводящую на экран случайно сгенерированное
трёхзначное натуральное число и его наибольшую цифру.
Примеры работы программы:
В числе 208 наибольшая цифра 8
В числе 774 наибольшая цифра 7
В числе 613 наибольшая цифра 6
 */
public class Task4 {
    public static void main(String[] args) {

        int n = (int) (Math.random() * 900) + 100;
        int a = Integer.parseInt("" + (Integer.toString(n)).charAt(0));
        int b = Integer.parseInt("" + (Integer.toString(n)).charAt(1));
        int c = Integer.parseInt("" + (Integer.toString(n)).charAt(2));

        System.out.println("In number " + n + " the largest digit is " + largestOf3(a, b, c) + ".");
        //System.out.println(n + " " + a + " " + b + " " + c);
    }

    private static int largestOf3 (int a, int b, int c) {
        if ( a >= b && a >= c ) return a;
        else if ( b >= a && b >= c ) return b;
        else return c;
    }


}
