
// JavaFX application to draw figure with lines

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

        double width = scene.getWidth(); // get width of scene
        double height = scene.getHeight(); // get height of scene

        // draw each side of the figure
        drawFirstLines(root, height, 0, 0, 0);

        drawSecondLines(root, width, height, 0, 0, width);

        drawThirdLines(root, height, 0, 0, 0);

        drawFourthLines(root, height, 0, width, 0);

        primaryStage.setTitle("Canvas demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void drawFirstLines(Group root, double height, double count, double incremStartY, double incremEndX){

        while(count != height){
            Line line = new Line(0, incremStartY, incremEndX, height);
            line.setStroke(Color.ORANGE);
            root.getChildren().add(line);

            incremEndX += 25;
            incremStartY += 25;

            count += 25;
        }
    }

    public static void drawSecondLines(Group root, double width, double height, double count, double incremStartY, double incremEndX){

        while(count != height){
            Line line = new Line(width, incremStartY, incremEndX, height);
            line.setStroke(Color.ORANGE);
            root.getChildren().add(line);

            incremEndX -= 25;
            incremStartY += 25;

            count += 25;
        }
    }

    public static void drawThirdLines(Group root, double width, double count, double incremStartX, double incremEndY){

        while(count != width){
            Line line = new Line(incremStartX, 0, width, incremEndY);
            line.setStroke(Color.ORANGE);
            root.getChildren().add(line);

            incremStartX += 25;
            incremEndY += 25;

            count += 25;
        }
    }

    public static void drawFourthLines(Group root, double height, double count, double incremStartY, double incremEndX){

        while(count != height){
            Line line = new Line(0, incremStartY, incremEndX, 0);
            line.setStroke(Color.ORANGE);
            root.getChildren().add(line);

            incremEndX += 25;
            incremStartY -= 25;

            count += 25;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
