/*
В городе N проезд в трамвае осуществляется по бумажным отрывным билетам. Каждую неделю трамвайное депо заказывает
в местной типографии рулон билетов с номерами от 000001 до 999999. «Счастливым» считается билетик у которого
сумма первых трёх цифр номера равна сумме последних трёх цифр, как, например, в билетах с номерами 003102 или 567576.
Трамвайное депо решило подарить сувенир обладателю каждого счастливого билета и теперь раздумывает,
как много сувениров потребуется. С помощью программы подсчитайте сколько счастливых билетов в одном рулоне?
 */
public class Task11 {
    public static void main(String[] args) {

        int n = 999999;

        System.out.println(luckyTickets(n));

    }

    private static int luckyTickets (int max) {

        int i = 1;
        int lucky = 0;
        String longNumber;

        for (int j = i; j <= max; j++) {

            int sum1 = 0, sum2 = 0;

            longNumber = addZeroes(j, max);

            for (int k = 0; k < longNumber.length()/2; k++) {
                sum1 = sum1 + Integer.parseInt ("" + longNumber.charAt(k));
            }

            for (int k = longNumber.length()/2; k < longNumber.length(); k++) {
                sum2 = sum2 + Integer.parseInt ("" + longNumber.charAt(k));
            }

            if ( sum1 == sum2 ) {
                lucky++;
                //System.out.println(longNumber);
            }
        }

        return lucky;
    }

    public static String addZeroes(int i, int max) {
        String number = Integer.toString(i);
        String length = Integer.toString(max);

        while (number.length() < length.length()) number = "0" + number;

        return number;
    }
}
