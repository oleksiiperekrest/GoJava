/*
Создайте массив, содержащий 10 первых нечетных чисел.
Выведете элементы массива на консоль в одну строку, разделяя запятой.
 */

public class Task1{
    public static void main(String[] args) {

        int[] m = new int[10];

        for (int i = 0; i < m.length; i++) {
            m[i] = i*2 + 1;
        }

        for (int i = 0; i < m.length; i++) {
            System.out.print(m[i] + ", ");

        }



    }

}
