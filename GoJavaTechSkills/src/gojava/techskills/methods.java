package gojava.techskills;

import java.util.Scanner;

/**
 * Here will lie all the everyday-useful methods.
 */
public class methods {
    public static int getIntInput() {
        Scanner input = new Scanner(System.in);
        while (!input.hasNextInt()) {
            System.out.println("(Enter a whole number)");
            input.next();
        }
        return input.nextInt();
}
