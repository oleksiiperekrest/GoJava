package Module5;

/*
В городе N есть большой склад на котором существует 50000 различных полок.
Для удобства работников руководство склада решило заказать для каждой полки табличку с номером
от 00001 до 50000 в местной типографии, но когда таблички напечатали, оказалось что печатный станок
из-за неисправности не печатал цифру 2, поэтому все таблички, в номерах которых содержалась одна или более двойка
(например, 00002 или 20202) — надо перепечатывать.
Напишите программу, которая подсчитает сколько всего таких ошибочных табличек оказалось в бракованной партии.
 */

public class Task12 {
    public static void main(String[] args) {

        int minNumber = 1;
        int maxNumber = 100;
        int failNumber = 2;

        System.out.println(numberFailed(failNumber, minNumber, maxNumber));
    }

    private static int numberFailed (int fail, int min, int max) {

        int failSum = 0;

        for (int i = min; i <= max; i++) {

            String number = Integer.toString(i);
            char n = Integer.toString(fail).charAt(0);

            for (int j = 0; j < number.length(); j++) {
                if ( n == number.charAt(j)) {
                    failSum++;
                    break;
                }
            }
        }

        return failSum;
    }
}
