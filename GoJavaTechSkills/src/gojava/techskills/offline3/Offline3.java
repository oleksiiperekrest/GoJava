package gojava.techskills.offline3;

import gojava.techskills.methods;

public class Offline3 {
    public static void main(String[] args) {

//        twoPointsDistance();
//        twoCirclesCollision();
        generateCircles(4);

    }

    public static void twoPointsDistance(){
        System.out.println("Enter coordinates for start point: ");
        Point startPoint = new Point(methods.getIntInput("Enter x coordinate."), methods.getIntInput("Enter y coordinate."));
        System.out.println("Enter coordinates for finish point: ");
        Point finishPoint = new Point(methods.getIntInput("Enter x coordinate."), methods.getIntInput("Enter y coordinate."));
        System.out.println("Distance between two points: " +  startPoint.calcLength(finishPoint));
    }

    public static void  twoCirclesCollision() {
        System.out.println("Enter data for first circle.");
        Circle firstCircle = createCircle();

        System.out.println("Enter data for second circle.");
        Circle secondCircle = createCircle();

        if (firstCircle.equals(secondCircle)) {
            System.out.println("Two circles are overlapping");
        } else {
            String collisionMessage = firstCircle.collisionCheck(secondCircle) ? "This two circles are colliding." :
                    "This two circles are not colliding.";
        }
    }

    public static Circle createCircle() {
        return new Circle(new Point((double)methods.getFloatInput("Enter x coordinate of the circle center."),
                (double)methods.getFloatInput("Enter y coordinate of the circle center.")),
                methods.getFloatInput("Enter circle radius."));
    }

    public static void generateCircles(int count) {
        CircleGenerator circles = new CircleGenerator(count);
        circles.printCirclesInfo();
    }
}
