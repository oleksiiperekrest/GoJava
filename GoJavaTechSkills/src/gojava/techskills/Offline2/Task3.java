package gojava.techskills.Offline2;

/*
Задача3
два инта А и Б
рекурсивно вывести все числа от А до Б
 */
public class Task3 {
    public static void main(String[] args) {
        countFromAtoB(1,4);
    }

    public static void countFromAtoB(int a, int b) {
        int start;
        if (a <= b) {
            start = a;
            if (a == b) System.out.println(b + " ");
            else {
                System.out.println(a);
                countFromAtoB(a + 1, b);
            }
        }
        else {

        }
    }
}
