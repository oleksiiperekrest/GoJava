package gojava.techskills.offline3;


public class Circle {
    private Point center = new Point(0,0);
    private double radius = 1;

    public Circle(Point point, double radius) {
        center = point;
        this.radius = radius;
    }

    public boolean collisionCheck(Circle otherCircle) {
        return this.center.calcLength(otherCircle.center) <= this.radius + otherCircle.radius ;
    }

    public boolean insideCheck(Circle otherCircle) {
        return Math.abs(this.radius - otherCircle.radius) >= this.center.calcLength(otherCircle.center);
    }

    public void printCircleInfo() {
        System.out.println("Coordinates of center:\n" +
                "x: " + this.center.x + ", y: " + this.center.y + ", radius: " + this.radius + ".");
    }

    public Circle generateRandomCircle(double range) {
        Point center = new Point(Math.random() * range, Math.random() * range);
        double radius = Math.random() * range;
        return new Circle(center, radius);
    }
}

