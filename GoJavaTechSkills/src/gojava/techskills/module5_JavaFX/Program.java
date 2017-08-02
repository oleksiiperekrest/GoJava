package gojava.techskills.module5_JavaFX;

import gojava.techskills.methods;
import gojava.techskills.module5_JavaFX.Snowman.DrawingASnowman;
import gojava.techskills.module5_JavaFX.Snowman.SnowmanUI;
import gojava.techskills.module5_JavaFX.Star.StarInterface;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Program extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    private static Pane canvas = new Pane();
    private final static int WIDTH = 640;
    private final static int HEIGHT = 480;

    public void start(Stage primaryStage) {
        canvas.setStyle("-fx-background-color: #90ee90;");

        selectTask();

        Scene scene = new Scene(canvas);
        primaryStage.setScene(scene);

        primaryStage.setMinWidth(WIDTH + 20);
        primaryStage.setMinHeight(HEIGHT + 45); //for snowman bottom to fit into the window

        primaryStage.show();
    }

    private static void selectTask() {
        String[] menu = new String[2];
        menu[0] = "1. Draw a snowman.";
        menu[1] = "2. Draw a star.";
        for (String line : menu) {
            System.out.println(line);
        }
        int userChoice = methods.getBoundIntInput(
                "Please choose which task you wish to execute:",
                "Please try again!",
                1, 2);

        switch (userChoice) {
            case 1:
                snowman(WIDTH, HEIGHT, canvas);
                break;
            case 2:
                star(canvas);
                break;
            default:
                System.out.println("Please try again");
        }

    }

    private static void snowman(int WIDTH, int HEIGHT, Pane canvas) {
        SnowmanUI.setWIDTH(WIDTH);
        DrawingASnowman.setHEIGHT(HEIGHT);

        SnowmanUI.drawInterface(canvas);
        SnowmanUI.drawSnowman(canvas);
    }

    private static void star(Pane canvas) {
        StarInterface.drawStar(canvas);

    }
}
