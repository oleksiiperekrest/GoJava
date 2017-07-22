package gojava.techskills.module4;

import gojava.techskills.methods;

class CountToNumber {

    /**
     * Prints natural numbers from 1 to x.
     *
     * @param x Number to be counted to.
     */
    static void countToNumber(int x) {
        if (x > 0) {
            for (int i = 0; i < x; i++) {
                System.out.print(i + 1 + " ");
            }
            System.out.println();
        } else if (x == 0) System.out.println("Ok, just for you i will count to zero:\n0");
        else System.out.println("Sorry, that number is negative, I don't know how to count it.");
    }

    /**
     * Prints natural numbers from 1 to x.
     *
     * @param x Number to be counted to.
     */
    static void countToNumberRecursively(int x) {
        if (x > 0) {
            if (x == 1) System.out.print("1 ");
            else {
                countToNumberRecursively(x - 1);
                System.out.print(x + " ");
            }
        } else if (x == 0) System.out.println("Ok, just for you i will count to zero:\n0");
        else System.out.println("Sorry, that number is negative, I don't know how to count it.");
    }

    /**
     * Asks user to enter a whole number.
     *
     * @return Integer number entered by user.
     */
    static int askIntNumber() {
        System.out.print("Enter a whole number: ");
        return methods.getIntInput();
    }
}
