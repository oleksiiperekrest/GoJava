package gojava.techskills.module6_JavaFX;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;


public class DrawingASnowman{

    final static int WIDTH = 640;
    final static int HEIGHT = 480;
    static Random random = new Random();
    static int xAxis = WIDTH/2;
    static Circle[] snowman;

    static Paint randomPaint() {
        Random random = new Random();
        Color color = new Color(random.nextDouble(),
                random.nextDouble(),
                random.nextDouble(),
                0.5);
        return Paint.valueOf(color.toString());
    }

    static Paint gradientPaint(int step, int steps) {
        Color color = new Color(1.0*step/steps, 1.0*step/steps, 1.0*step/steps, 1);
        return Paint.valueOf(color.toString());
    }

    static double randomRadius(double min, double max) {
        return min + (max - min) * random.nextDouble();
    }

    static void circles(int count, Pane canvas, double minRadius, double maxRadius) {
        if (count > 0) {
            snowman = new Circle[count + 3]; //+3 for two eyes and a nose
            drawCircle(count, snowman, minRadius, maxRadius);

            for (Circle globe : snowman) {
                canvas.getChildren().addAll(globe);
            }
        }
    }

    static void paintRed(Circle[] snowman) {
        for (int i = 0; i < snowman.length-3; i++) {
            snowman[i].setFill(Paint.valueOf("#FF0000"));
        }
    }

    static void paintGradient(Circle[] snowman) {
        snowman[0].setFill(Paint.valueOf("#000000FF"));
        for (int i = snowman.length-4; i > 0; i--) {
            snowman[i].setFill(gradientPaint(i, snowman.length-3));
        }
    }

    static void drawCircle(int count, Circle[] snowman, double minRadius, double maxRadius) {

        if (count > 0) {
            double radius = randomRadius(minRadius, maxRadius);
            double y = HEIGHT - radius;
            Circle circle = new Circle(xAxis, y, radius, randomPaint());
            circle.setStroke(Paint.valueOf("#000000"));
            snowman[0] = circle;
            if (count == 1) drawEyesAndNose(y, radius, snowman, count+3);
            if (count > 1) {
                drawCircle(y, radius, count - 1, snowman, count+3, minRadius,  maxRadius);
            }
        }
    }

    static void drawCircle(double prevY, double prevRadius, int recursionCount, Circle[] snowman,
                           int count, double minRadius, double maxRadius) {
        double radius = randomRadius(minRadius, maxRadius);
        double y = prevY - prevRadius - radius;
        Circle circle = new Circle(xAxis, y, radius, randomPaint());
        circle.setStroke(Paint.valueOf("#000000"));
        snowman[count - 3 - recursionCount] = circle;
        if (recursionCount == 1) drawEyesAndNose(y, radius, snowman, count);

        if (recursionCount > 1) drawCircle(y, radius, recursionCount-1, snowman, count, minRadius, maxRadius );
    }

    static void drawEyesAndNose(double height, double radius, Circle[] snowman, int count) {
        snowman[count - 3] = drawLeftEye(height,radius);
        snowman[count - 2] = drawRighttEye(height,radius);
        snowman[count - 1] = drawNose(height, radius);

    }

    static Circle drawLeftEye(double height, double radius) {
        return new Circle(xAxis - radius/3, height - radius/2 ,
                random.nextDouble()*radius/3);
    }

    static Circle drawRighttEye(double height, double radius) {
        return new Circle(xAxis + radius/3, height - radius/2 ,
                random.nextDouble()*radius/3);
    }

    static Circle drawNose(double height, double radius) {
        Circle nose = new Circle(xAxis, height + radius/5 ,
                random.nextDouble()*radius/3, Paint.valueOf("#FF6600"));
        nose.setStroke(Paint.valueOf("#000000"));
        return nose;
    }
}
