package Module4;

/*Создать программу, которая будет проверять попало ли случайно выбранное из отрезка [5;155] целое число в интервал (25;100) и сообщать результат на экран.
Примеры работы программы:
Число 113 не содержится в интервале (25,100)
Число 72 содержится в интервале (25,100)
Число 25 не содержится в интервале (25,100)
Число 155 не содержится в интервале (25,100)
 */

public class Task3 {

    public static void main(String[] args) {

        int n = (int)(Math.random() * 151) + 5;
        if(n > 25 && n < 100) {
            System.out.println("Number " + n + " is found within interval (25,100).");
        } else {
            System.out.println("Number " + n + " is not found within interval (25,100).");
        }

    }
}
