package gojava.techskills.module6_JavaFX.Snowman;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;

public class SnowmanUI {

    private static int WIDTH;
    private static TextField countField;
    private static int count = 4;
    private static TextField minRadius;
    private static double minRad = 20;
    private static TextField maxRadius;
    private static double maxRad = 70;
    private static Label error = addErrorLabel();

    public static void setWIDTH(int WIDTH) {
        SnowmanUI.WIDTH = WIDTH;
    }

    public static void drawInterface(Pane canvas) {
        canvas.getChildren().addAll(
                addCountLabel(),
                addCountField(),
                addMinRadiusLabel(),
                addMinRadiusField(),
                addMaxRadiusLabel(),
                addMaxRadiusField(),
                addPaintRedButton(),
                addGradientButton(),
                addGenerateButton(canvas)
                );
    }

    public static void drawSnowman(Pane canvas) {
        DrawingASnowman.setWIDTH(WIDTH);
        DrawingASnowman.drawSnowman(readCount(countField, canvas, error), canvas,
                readRadius(minRadius, canvas, error),
                readRadius(maxRadius, canvas, error));
    }

    private static Label addCountLabel() {
        Label countLabel = new Label("Snowballs count:");
        countLabel.setTranslateX(WIDTH - 195);
        countLabel.setTranslateY(15);
        return countLabel;
    }

    private static TextField addCountField() {
        TextField countField = new TextField(""+count);
        countField.setMaxWidth(40);
        countField.setTranslateX(WIDTH - 100);
        countField.setTranslateY(10);
        return SnowmanUI.countField = countField;
    }

    private static Label addMinRadiusLabel() {
        Label minRadiusLabel = new Label("Minimal radius:");
        minRadiusLabel.setTranslateX(WIDTH - 188);
        minRadiusLabel.setTranslateY(45);
        return minRadiusLabel;
    }

    private static TextField addMinRadiusField() {
        TextField minRadiusField = new TextField(""+minRad);
        minRadiusField.setMaxWidth(40);
        minRadiusField.setTranslateX(WIDTH - 100);
        minRadiusField.setTranslateY(40);
        return minRadius = minRadiusField;
    }

    private static Label addMaxRadiusLabel() {
        Label maxRadiusLabel = new Label("Maximal radius:");
        maxRadiusLabel.setTranslateX(WIDTH - 188);
        maxRadiusLabel.setTranslateY(75);
        return maxRadiusLabel;
    }

    private static TextField addMaxRadiusField() {
        TextField maxRadiusField = new TextField(""+maxRad);
        maxRadiusField.setMaxWidth(40);
        maxRadiusField.setTranslateX(WIDTH - 100);
        maxRadiusField.setTranslateY(70);
        return maxRadius = maxRadiusField;
    }

    private static Label addErrorLabel() {
        Label error = new Label("Wrong input!");
        error.setScaleX(4);
        error.setScaleY(4);
        error.setTranslateX(280);
        error.setTranslateY(100);
        error.setTextFill(Paint.valueOf("#FF0000"));
        return error;
    }

    private static Button addPaintRedButton() {
        Button paintRed = new Button();
        paintRed.setTranslateX(WIDTH - 100);
        paintRed.setTranslateY(148);
        paintRed.setText("Paint red");
        paintRed.setOnMouseClicked(event -> {
            DrawingASnowman.paintRed(DrawingASnowman.snowman);
        });
        return paintRed;
    }

    private static Button addGradientButton() {
        Button gradient = new Button();
        gradient.setTranslateX(WIDTH - 100);
        gradient.setTranslateY(178);
        gradient.setText("Gradient");
        gradient.setOnMouseClicked(event -> {
            DrawingASnowman.paintGradient(DrawingASnowman.snowman);
        });
        return gradient;
    }

    private static Button addGenerateButton(Pane canvas) {
        Button generate = new Button();
        generate.setTranslateX(WIDTH - 100);
        generate.setTranslateY(100);
        generate.setText("Generate\na snowman");
        generate.setOnMouseClicked(event -> {
            if (readRadius(minRadius, canvas, error) >
                    readRadius(maxRadius, canvas, error)
                    ||
                    readRadius(minRadius, canvas, error) == -1
                    ||
                    readCount(countField, canvas, error) < 0) {
                canvas.getChildren().removeAll(error);
                canvas.getChildren().addAll(error);
            }
            else {
                canvas.getChildren().removeAll(error);
                canvas.getChildren().removeAll(DrawingASnowman.snowman);
                DrawingASnowman.drawSnowman(count = readCount(countField, canvas, error), canvas,
                        minRad = readRadius(minRadius, canvas, error),
                        maxRad = readRadius(maxRadius, canvas, error));
                drawInterface(canvas);
            }
        });
        return generate;
    }

    private static int readCount(TextField count, Pane canvas, Label error) {
        int result;

            try {
                result = Integer.parseInt(count.getText());
                return result;
            } catch (IllegalArgumentException e) {
                canvas.getChildren().removeAll(error);
                canvas.getChildren().addAll(error);
            }
        return 0;
    }

    private static double readRadius(TextField radius, Pane canvas, Label error) {
        double result;

            try {
                result = Double.parseDouble(radius.getText());
                if (result >= 0) return result;
                else return -1;
            } catch (IllegalArgumentException e) {
                canvas.getChildren().removeAll(error);
                canvas.getChildren().addAll(error);
                return -1;
            }

    }
}
