package gojava.techskills.offline4;

public class Point {

    private double x, y;
    static final Point ZERO = new Point(0,0);

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double calcLength (Point otherPoint) {
        return Math.sqrt((x - otherPoint.x)*(x - otherPoint.x) + (y - otherPoint.y)*(y - otherPoint.y));
    }

    public double calcLength() {
        return calcLength(ZERO);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /*When you normalize a vector you make the length of it equal to 1. To normalize you just devide
        the x, y, z coords by the length of the vector. This then gives you the Unit Vector.*/

    public Point normalize() {
        return new Point(x / calcLength(), y / calcLength());
    }
    public Point normalize(Point otherPoint) {
        return new Point(x / calcLength(otherPoint), y / calcLength(otherPoint));
    }

    public Point multiply(double multiplier) {
        return new Point(x * multiplier, y * multiplier);
    }

    public Point add(Point otherPoint) {
        return new Point(x + otherPoint.getX(), y + otherPoint.getY());
    }

    public Point subtract(Point otherPoint) {
        return new Point(x - otherPoint.getX(), y - otherPoint.getY());
    }

}
