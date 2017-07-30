package gojava.techskills.module6_JavaFX;

import gojava.techskills.module6_JavaFX.Snowman.DrawingASnowman;
import gojava.techskills.module6_JavaFX.Snowman.SnowmanUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Program extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        Pane canvas = new Pane();
        canvas.setStyle("-fx-background-color: #90ee90;");
        final int WIDTH = 640;
        final int HEIGHT = 480;

        snowman(WIDTH, HEIGHT, canvas);

        Scene scene = new Scene(canvas);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(WIDTH + 20);
        primaryStage.setMinHeight(HEIGHT + 45);
        primaryStage.show();
    }

    private static void snowman(int WIDTH, int HEIGHT, Pane canvas) {
        SnowmanUI.setWIDTH(WIDTH);
        DrawingASnowman.setWIDTH(WIDTH);
        DrawingASnowman.setHEIGHT(HEIGHT);

        SnowmanUI.drawInterface(canvas);
        SnowmanUI.drawSnowman(canvas);
    }
}
