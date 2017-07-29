package gojava.techskills.offline4;


import javafx.scene.layout.Pane;

import java.util.Random;

public class Line {
    private Point p1;
    private Point p2;
    private javafx.scene.shape.Line lineFx;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
    Random random = new Random();
    public Line() {
        p1 = new Point(random.nextDouble()*800, random.nextDouble() *800);
        p2 = new Point(random.nextDouble()*800, random.nextDouble()*800);
    }

    public double calcLength() {
        return p1.calcLength(p2);
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public Point getPointOnLine(double percent) {

        Point d = p2.subtract(p1); // translate vector to zero point ((p1-p1), (p2-p1)) = ((0,0) , (p2-p1))

        d = d.normalize();  // normalize vector
        double length = p1.calcLength(p2) * percent; // multiply initial vector length for desired percent length

        d = d.multiply(length); // multiply unit vector for required length

        return d.add(p1); // translate vector back to starting point 1
    }

    public void draw(Pane canvas) {

    }

    public javafx.scene.shape.Line getLineFx() {
        lineFx = new javafx.scene.shape.Line(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        return lineFx;
    }

}
