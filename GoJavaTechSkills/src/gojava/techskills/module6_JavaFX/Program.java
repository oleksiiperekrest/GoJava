package gojava.techskills.module6_JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Program extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        final int WIDTH = 640;
        final int HEIGHT = 480;

        primaryStage.setMinWidth(WIDTH + 20);
        primaryStage.setMinHeight(HEIGHT + 45);

        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: #90ee90;");

        Scene scene = new Scene(canvas);

        DrawingASnowman.circles(1, canvas, 20, 70);


        Label countLabel = new Label("Snowballs count:");
        countLabel.setTranslateX(WIDTH - 195);
        countLabel.setTranslateY(15);

        TextField countField = new TextField("4");
        countField.setMaxWidth(40);
        countField.setTranslateX(WIDTH - 100);
        countField.setTranslateY(10);

        Label minRadiusLabel = new Label("Minimal radius:");
        minRadiusLabel.setTranslateX(WIDTH - 188);
        minRadiusLabel.setTranslateY(45);

        TextField minRadiusField = new TextField("20");
        minRadiusField.setMaxWidth(40);
        minRadiusField.setTranslateX(WIDTH - 100);
        minRadiusField.setTranslateY(40);

        Label maxRadiusLabel = new Label("Maximal radius:");
        maxRadiusLabel.setTranslateX(WIDTH - 188);
        maxRadiusLabel.setTranslateY(75);

        TextField maxRadiusField = new TextField("70");
        maxRadiusField.setMaxWidth(40);
        maxRadiusField.setTranslateX(WIDTH - 100);
        maxRadiusField.setTranslateY(70);

        Label error = new Label("Wrong input!");
        error.setScaleX(4);
        error.setScaleY(4);
        error.setTranslateX(280);
        error.setTranslateY(100);
        error.setTextFill(Paint.valueOf("#FF0000"));

        Button paintRed = new Button();
        paintRed.setTranslateX(WIDTH - 100);
        paintRed.setTranslateY(148);
        paintRed.setText("Paint red.");
        paintRed.setOnMouseClicked(event -> {
            DrawingASnowman.paintRed(DrawingASnowman.snowman);
        });

        Button gradient = new Button();
        gradient.setTranslateX(WIDTH - 100);
        gradient.setTranslateY(178);
        gradient.setText("Gradient");
        gradient.setOnMouseClicked(event -> {
            DrawingASnowman.paintGradient(DrawingASnowman.snowman);
        });

        Button generate = new Button();
        generate.setTranslateX(WIDTH - 100);
        generate.setTranslateY(100);
        generate.setText("Generate \na snowman.");
        generate.setOnMouseClicked(event -> {

            if(getRadius(minRadiusField, canvas, error) > getRadius(maxRadiusField, canvas, error))
                canvas.getChildren().addAll(error);
            else {
                canvas.getChildren().clear();

                canvas.getChildren().addAll(generate, paintRed, gradient, countLabel, countField, minRadiusField, minRadiusLabel,
                        maxRadiusField, maxRadiusLabel);
                DrawingASnowman.circles(getCount(countField, canvas, error), canvas,
                        getRadius(minRadiusField, canvas, error), getRadius(maxRadiusField, canvas, error));


            }
        });

        canvas.getChildren().addAll(generate, paintRed, gradient, countLabel, countField, minRadiusField, minRadiusLabel,
                maxRadiusField, maxRadiusLabel);



        primaryStage.setScene(scene);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);
        primaryStage.show();
    }

    static int getCount(TextField count, Pane canvas, Label error) {
        int result;
        while (true) {
            try {
                result = Integer.parseInt(count.getText());
                return result;
            } catch (IllegalArgumentException e) {
                canvas.getChildren().addAll(error);
            }
        }
    }

    static double getRadius(TextField radius, Pane canvas, Label error) {
        double result;
        while (true) {
            try {
                result = Double.parseDouble(radius.getText());
                if (result >= 0)return result;
                else canvas.getChildren().addAll(error);
            } catch (IllegalArgumentException e) {
                canvas.getChildren().addAll(error);
            }
        }
    }
}
