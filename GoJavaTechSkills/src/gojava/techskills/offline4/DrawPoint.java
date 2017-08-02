package gojava.techskills.offline4;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.stage.Stage;


public class DrawPoint extends Application {
    final int WIDTH = 800;
    final int HEIGHT = 800;
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {


        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        gojava.techskills.offline4.Line randomLine = new gojava.techskills.offline4.Line();

        Line randomLineFx = randomLine.getLineFx();
        randomLineFx.setStrokeWidth(3);
        randomLineFx.setStyle("-fx--color: red;");



        Point point = randomLine.getPointOnLine(0.48);
        gojava.techskills.offline4.Line linePercent = new gojava.techskills.offline4.Line(randomLine.getP1(), point);

        Line linePercentFx = linePercent.getLineFx();
        linePercentFx.setStrokeWidth(10);
        linePercentFx.setFill(Paint.valueOf("#FF0000"));


        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: white;");
        canvas.getChildren().addAll(randomLineFx);


        Scene scene = new Scene(canvas);


        Button buttonDrawPercent = new Button();
        buttonDrawPercent.setTranslateX(680);
        buttonDrawPercent.setTranslateY(50);
        buttonDrawPercent.setText("Draw Percent");
        buttonDrawPercent.setOnMouseClicked(event -> {
            canvas.getChildren().addAll(linePercentFx);
        });

        Button buttonGenerateLine = new Button();
        buttonGenerateLine.setTranslateX(680);
        buttonGenerateLine.setTranslateY(120);
        buttonGenerateLine.setText("Generate line");
        buttonGenerateLine.setOnMouseClicked(event -> {
            canvas.getChildren().addAll(linePercentFx);
        });



        canvas.getChildren().addAll(buttonGenerateLine, buttonDrawPercent);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static void generateLine() {

    }
}

