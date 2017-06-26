package Module2;

/*В переменной n хранится вещественное число с ненулевой дробной частью.
Создайте программу, которая округляет число n до ближайшего целого и выводящую результат на экран.
 */

public class Task3 {

    public static void main(String[] args) {
        double n = 124.515;
        int m = (int)n;
        if(n % (double)m >= 0.5) {
            ++m;
        }

        System.out.println(n + " is rounded to " + m + ".");
    }
}
