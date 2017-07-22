package gojava.techskills.module4;

import gojava.techskills.methods;

class CompareTwoNumbers {

    /**
     * Gets input of two numbers and calls getMax() to compare them and print out greater of them.
     */
    static void compareTwoNumbers() {
        float floatA = methods.getFloatInput("Enter first number.");
        float floatB = methods.getFloatInput("Enter second number.");
        int intA = (int) floatA, intB = (int) floatB;

        System.out.print("Maximum number is: ");
        if ((floatA % intA == 0) && (floatB % intB == 0)) System.out.println(getMax(intA, intB));
        else System.out.println(getMax(floatA, floatB));
    }

    /**
     * @param a Integer number to be compared.
     * @param b Integer number to be compared.
     * @return Greater of two numbers.
     */
    private static int getMax(int a, int b) {
        return a >= b ? a : b;
    }

    /**
     * @param a Float number to be compared.
     * @param b Float number to be compared.
     * @return Greater of two numbers.
     */
    private static float getMax(float a, float b) {
        return a >= b ? a : b;
    }
}
