package gojava.techskills.module5_JavaFX.Star;

import gojava.techskills.methods;
import javafx.scene.layout.Pane;

public class StarInterface {

    public static void drawStar(Pane canvas) {
        double centerX = methods.getDoubleInput("Enter X coordinate of the center point.");
        double centerY = methods.getDoubleInput("Enter Y coordinate of the center point.");
        double radius = methods.getDoubleInput("Enter radius of the star.");
        double offsetAngle = Math.PI/5*-0.5; // this is what sets the two bottom beams horizontally
        Star.drawLines(canvas, centerX, centerY, radius, offsetAngle);
    }
}
