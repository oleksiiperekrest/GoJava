package gojava.techskills;

import java.util.Scanner;

/**
 * Here will lie all the everyday-useful methods.
 */
public class methods {

    /**
     * @return An integer input from the user.
     */
    public static int getIntInput() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("(Enter a whole number!)");
            input.next();
        }
        return input.nextInt();
    }

    /**
     * @return An integer input from the user.
     */
    public static int getIntInput(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("(Enter a whole number!)");
            input.next();
        }
        return input.nextInt();
    }

    /**
     * Gets user input of a positive integer.
     *
     * @param message Message to be displayed to invite input.
     * @return Positive integer entered by user.
     */
    public static int getPositiveIntInput(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);

        while (true) {
            String line = input.nextLine();
            try {
                int n = Integer.parseInt(line);
                if (n >= 0) {
                    return n;
                }
            } catch (NumberFormatException e) {

            }
            System.out.print("(Enter a positive whole number!)\n" + message);
        }
    }

    public static int getBoundIntInput(String message, int lowerBound, int upperBound) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);

        while (true) {
            String line = input.nextLine();
            try {
                int n = Integer.parseInt(line);
                if (n >= lowerBound && n <= upperBound) {
                    return n;
                }
            } catch (NumberFormatException e) {

            }
            System.out.print("(Enter a positive whole number between " + lowerBound + " and " + upperBound +
                    "!)\n" + message);
        }
    }

    /**
     * @return An float number input by user.
     */
    public static float getFloatInput() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextFloat()) {
            System.out.println("(Enter a number!)");
            input.next();
        }
        return input.nextFloat();
    }

    /**
     *
     * @param message Message shown to user to invite input.
     * @return An float number input by user.
     */
    public static float getFloatInput(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        while (!input.hasNextFloat()) {
            System.out.println("(Enter a number!)");
            input.next();
        }
        return input.nextFloat();
    }

    /**
     *
     * @param message Message shown to user to invite input.
     * @return An float number input by user.
     */
    public static double getDoubleInput(String message) {
        System.out.println(message);
        Scanner input = new Scanner(System.in);
        while (!input.hasNextDouble()) {
            System.out.println("(Enter a number!)");
            input.next();
        }
        return input.nextDouble();
    }

    /**
     *
     * @param length Predetermined length of array.
     * @param message Message shown to user to invite input.
     * @return Array of integers entered by user.
     */
    public static int[] getIntsArrayInput(int length, String message) {
        System.out.println(message);
        int[] array = new int[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = getIntInput("Enter integer number (" + (i+1) + " of " + length + ").");
        }
        return array;
    }

    /**
     *
     * @param length Predetermined length of array.
     * @param message Message shown to user to invite input.
     * @return Array of floats entered by user.
     */
    public static float[] getFloatsArrayInput(int length, String message) {
        System.out.println(message);
        float[] array = new float[length];

        for (int i = 0; i < array.length; i++) {
            array[i] = getFloatInput("Enter a number (" + (i+1) + " of " + length + ").");
        }
        return array;
    }

    public static boolean yesNo(String message) {
        Scanner input = new Scanner(System.in);
        String line;
        boolean yn;

        System.out.println(message + " (y/n)");
        while (true) {
            line = input.nextLine().trim().toLowerCase();

            if (line.equals("y")) {
                yn = true;
                break;
            } else if (line.equals("n")) {
                yn = false;
                break;
            } else {
                System.out.println("Please answer \"y\" or \"n\".");
            }
        }
        return yn;
    }
}
