package gojava.techskills.module4;


import gojava.techskills.methods;

class DrawRectangle {

    /**
     * Asks user to input two positive integers to be used as sides of a rectangle.
     *
     * @return Array of 2 positive integers.
     */
    static int[] askRectangleSides() {
        int[] sides = new int[2];
        sides[0] = methods.getPositiveIntInput("Enter length of a rectangle.");
        sides[1] = methods.getPositiveIntInput("Enter width of a rectangle.");
        return sides;
    }

    /**
     * Draws a rectangle with '+' signs, length and width defined by an array of 2 positive integers.
     *
     * @param sides Array of 2 positive integers.
     */
    static void drawRectangle(int[] sides) {
        for (int i = 0; i < sides[0]; i++) {
            for (int j = 0; j < sides[1]; j++) {
                System.out.print("+ ");
            }
            System.out.println();
        }
    }

    /**
     * Control function for drawRectangleRecursively(int height, int width, int resWidth)
     * Asks user input of two positive integers and transfers as 3 arguments for recursive drawing.
     */
    static void drawRectangleRecursively() {
        int a = methods.getPositiveIntInput("Enter height of a rectangle.");
        int b = methods.getPositiveIntInput("Enter width of a rectangle.");
        System.out.println("Height = " + a + ", width = " + b + ".");
        drawRectangleRecursively(a, b, b);
        System.out.println();
    }

    /**
     * Draws a rectangle with '+' signs of assigned height and width to console
     *
     * @param height   Height (rows count).
     * @param width    Width (column count).
     * @param resWidth Reserve width for recursive calls. MUST BE EQUAL TO WIDTH ↑.
     */
    private static void drawRectangleRecursively(int height, int width, int resWidth) {
        if (height > 0 || width > 0) {
            if (width > 0) {
                System.out.print("+ ");
                drawRectangleRecursively(height, width - 1, resWidth);
                return;
            }
            if (height > 1) {
                System.out.println();
                drawRectangleRecursively(height - 1, resWidth, resWidth);
            }
        }
    }

    /**
     * Draws a square with '+' signs, length and width defined by an integer.
     *
     * @param side Positive integers.
     */
    static void drawRectangle(int side) {

        for (int i = 0; i < side; i++) {
            for (int j = 0; j < side; j++) {
                System.out.print("+ ");
            }
            System.out.println();
        }
    }
}
