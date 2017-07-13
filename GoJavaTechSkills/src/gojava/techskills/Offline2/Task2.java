package gojava.techskills.Offline2;

import gojava.techskills.methods;

/*
Задача 2
...
 */
public class Task2 {
    public static void main(String[] args) {
        int x = methods.getIntInput("Enter number to be powered!");
        int pow = methods.getIntInput("Enter power!");
        System.out.println(x + "^" + pow + " = " + powerRecursive(x,pow));
    }

    /**
     *
     * @param x Int number to be (powered!).
     * @param power int (power!)
     * @return Returns x^n (X to requested power).
     */
    public static int powerRecursive(int x, int power) {
        int result;
        if (power == 0) return 1;
        result = x * powerRecursive(x, power-1);
        return result;
    }

}


