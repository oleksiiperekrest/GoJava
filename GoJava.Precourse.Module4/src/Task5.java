/*
В три переменные a, b и c явно записаны программистом три целых попарно неравных между собой числа.
Создать программу, которая переставит числа в переменных таким образом, чтобы
при выводе на экран последовательность a, b и c оказалась строго возрастающей.
Числа в переменных a, b и c: 3, 9, -1
Возрастающая последовательность: -1, 3, 9
Числа в переменных a, b и c: 2, 4, 3
Возрастающая последовательность: 2, 3, 4
Числа в переменных a, b и c: 7, 0, -5
Возрастающая последовательность: -5, 0, 7
 */

import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {

        int a = 78;
        int b = 7;
        int c = -11;

        int[] m = new int[3];
        m[0] = a;
        m[1] = b;
        m[2] = c;

        m = sortMass3(m);


        System.out.println("Numbers in variables a, b, c are: " + a + ", " + b + ", " + c + ". " +
                "\nIn ascending order: " + m[0] + ", " + m[1] + ", " + m[2] + ".");
    }

    private static int[] sortMass3(int[] mass) {

        int m0 = mass[0];
        int m1 = mass[1];
        int m2 = mass[2];

        if (m0 <= m1 && m0 <= m2) {
            if (m2 <= m1) {
                mass[1] = m2;
                mass[2] = m1;
            }
        }

        if (m1 <= m0 && m1 <= m2) {
            mass[0] = m1;
            if (m0 <= m2) {
                mass[1] = m0;
            }
            else {
                mass[1] = m2;
                mass[2] = m0;
            }
        }

        if (m2 <= m0 && m2 <= m1) {
            mass[0] = m2;
            if (m0 <= m1) {
                mass[1] = m0;
                mass[2] = m1;
            }
            else mass[2] = m0;
        }

        return mass;
    }
}
