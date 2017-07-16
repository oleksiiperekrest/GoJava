package gojava.techskills.Offline2;

/*
Задача 3
Задача на рекурсию.
Даны два целых числа A и В (каждое в отдельной строке).
Выведите все числа от A до B включительно, в порядке возрастания.
*/

public class Task3 {
    public static void main(String[] args) {
        countFromAtoB(7, 4);
    }

    public static void countFromAtoB(int a, int b) {
        if (a <= b) {
            if (a == b) System.out.println(b + " ");
            else {
                System.out.println(a);
                countFromAtoB(a + 1, b);
            }
        } else {
            if (a == b) System.out.println(b + " ");
            else {
                System.out.println(a);
                countFromAtoB(a - 1, b);
            }
        }
    }
}
