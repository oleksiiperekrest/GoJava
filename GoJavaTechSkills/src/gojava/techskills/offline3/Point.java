package gojava.techskills.offline3;

public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // c2 = (xA − xB)2 + (yA − yB)2
    public double calcLength (Point otherPoint) {
        return Math.sqrt((x - otherPoint.x)*(x - otherPoint.x) + (y - otherPoint.y)*(y - otherPoint.y));
    }

    public Point randomPoint(double range) {
        return new Point(Math.random() * range, Math.random() * range);
    }
}