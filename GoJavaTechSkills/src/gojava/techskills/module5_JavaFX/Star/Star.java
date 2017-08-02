package gojava.techskills.module5_JavaFX.Star;

import gojava.techskills.module5_JavaFX.Snowman.DrawingASnowman;
import gojava.techskills.offline4.Point;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class Star {
    private static Point center;
    private static Point[] points;
    private static int vertices = 5;
    private static int skip = 2;
    private static double radius;
    private static double radiusRatio = Math.cos(Math.PI/ vertices * skip) / Math.cos(Math.PI/ vertices * (skip - 1));

    private static void setCenter(double x, double y) {
        center = new Point(x, y);
    }

    public static void setVertices(int vertices) {
    }

    private static void setRadius(double rad) {
        radius = rad;
    }

    private static Point[] findPoints(Point center, double radius, double offsetAngle) {
        Point[] points = new Point[vertices*2];
        double smallRadius = radius * radiusRatio;
        double turnAngle = Math.PI / vertices;

        for (int i = 0; i < points.length; i++) {

            points[i] = new Point(Math.cos(offsetAngle+turnAngle * i), Math.sin(offsetAngle+turnAngle * i))
                    .multiply(i % 2 == 0 ? radius : smallRadius).add(center);

        }
        return points;
    }

    private static Line[] findLines(Point[] points) {
        Line[] lines = new Line[points.length];
        lines[0] = new Line(points[0].getX(), points[0].getY(), points[9].getX(), points[9].getY());
        for (int i = 1; i < lines.length; i++) {
            lines[i] = new Line(points[i-1].getX(), points[i-1].getY(), points[i].getX(), points[i].getY());
        }

        return lines;
    }

    static void drawLines(Pane canvas, double centerX, double centerY, double radius, double offsetAngle) {
        setCenter(centerX, centerY);
        setRadius(radius);
        Line[] lines = findLines(findPoints(new Point(centerX,centerY), radius, offsetAngle));

        for (int i = 0; i < lines.length; i++) {
            lines[i].setStrokeWidth((int)radius/30+1); //for better looking: the bigger the star the thicker the lines
            lines[i].setStroke(DrawingASnowman.randomPaint()); //do i really need it though?
            canvas.getChildren().addAll(lines[i]);
        }
    }

}
