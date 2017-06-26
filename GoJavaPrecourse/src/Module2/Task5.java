package Module2;

/*Переменная “weekend” истинна если сейчас выходной и переменная “vacation” истина если мы в отпуске.
Мы высыпаемся если сейчас выходной, либо мы в отпуске. Вернуть истинно, если мы высыпаемся:
sleepIn(false, false) -> true
sleepIn(true, false) -> false
sleepIn(false, true) -> true


public static boolean sleepIn(boolean weekday, boolean vacation) {

}
 */

public class Task5 {

    public static void main(String[] args) {

        boolean weekend = false;
        boolean vacation = false;
        String day = "Saturday";
        if(day == "Saturday" || day == "Sunday") {
            weekend = true;
        }

        boolean sleep = sleepIn(!weekend, vacation);
        System.out.println(sleep);
    }

    public static boolean sleepIn(boolean weekday, boolean vacation) {

        return !weekday || vacation;
    }
}
