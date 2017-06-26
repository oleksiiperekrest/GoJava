package Module4;

/*Генерируется случайное число от 1 - 12. Выведите на экран (только)название месяца соответствующему номеру.
switch (month){
case 0: sout(“January”); break;
case 1: sout(“Febrary”);break;
….
}
 */

public class Task2 {

    public static void main(String[] args) {

        int month = (int)(Math.random() * 12);
        switch(month) {
            case 0:
                System.out.println("January");
                break;
            case 1:
                System.out.println("February");
                break;
            case 2:
                System.out.println("March");
                break;
            case 3:
                System.out.println("April");
                break;
            case 4:
                System.out.println("May");
                break;
            case 5:
                System.out.println("June");
                break;
            case 6:
                System.out.println("July");
                break;
            case 7:
                System.out.println("August");
                break;
            case 8:
                System.out.println("September");
                break;
            case 9:
                System.out.println("October");
                break;
            case 10:
                System.out.println("November");
                break;
            case 11:
                System.out.println("December");
        }

    }
}
