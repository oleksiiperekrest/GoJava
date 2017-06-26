package Module5;

/*
Электронные часы показывают время в формате от 00:00 до 23:59.
Подсчитать сколько раз за сутки случается так, что слева от двоеточия показывается симметричная комбинация для той,
что справа от двоеточия (например, 02:20, 11:11 или 15:51).
 */

public class Task13 extends Task11 {
    public static void main(String[] args) {

        clockSymmetry();
    }

    public static void clockSymmetry() {
        String hours, minutes;
        int symmetryCount = 0;

        for (int i = 0; i < 24; i++) {

            hours = addZeroes(i, 10);

            for (int j = 0; j < 60; j++) {
                minutes = addZeroes(j, 10);

                if ( hours.charAt(0) == minutes.charAt(1) && hours.charAt(1) == minutes.charAt(0) ) {
                    symmetryCount++;
                    System.out.println(symmetryCount + ". " + hours + ":" + minutes);
                }
            }

        }
        //System.out.println(symmetryCount);
    }
}
