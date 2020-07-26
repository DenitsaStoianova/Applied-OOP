package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();
        Scene scene = new Scene(root, 500,500);

        // calculate x and y coordinates of center of the scene
        double centerX = scene.getWidth() / 2;
        double centerY = scene.getHeight() / 2;

        int count = 0; // count of lines of each side of square shaped spiral
        double increm = 35; // to determine start and end point coordinates of each line of square shaped spiral

        while(count < 5){

            // draw right vertical lines of square shaped spiral
            drawRightLine(root, centerX, centerY, increm - 35);

            // draw down horizontal lines of square shaped spiral
            drawDownLine(root, centerX, centerY, increm);

            // draw left vertical lines of square shaped spiral
            drawLeftLine(root, centerX, centerY, increm);

            // draw upper horizontal lines of square shaped spiral
            drawUpperLine(root, centerX, centerY, increm);

            increm += 35;
            count++;
        }

        primaryStage.setTitle("Draw square shaped spiral");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void drawRightLine(Group root, double centerX, double centerY, double increm){

        Line line = new Line(centerX + increm, centerY - increm, centerX + increm, centerY + 35 + increm);
        line.setStroke(Color.RED);
        root.getChildren().add(line);
    }

    public static void drawLeftLine(Group root, double centerX, double centerY, double increm){

        Line line = new Line(centerX - increm, centerY - increm, centerX - increm, centerY + increm);
        line.setStroke(Color.RED);
        root.getChildren().add(line);
    }

    public static void drawDownLine(Group root, double centerX, double centerY, double increm){

        Line line = new Line(centerX - increm, centerY + increm, centerX + increm - 35, centerY + increm);
        line.setStroke(Color.RED);
        root.getChildren().add(line);
    }

    public static void drawUpperLine(Group root, double centerX, double centerY, double increm){

        Line line = new Line(centerX - increm, centerY - increm, centerX + increm, centerY - increm);
        line.setStroke(Color.RED);
        root.getChildren().add(line);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
