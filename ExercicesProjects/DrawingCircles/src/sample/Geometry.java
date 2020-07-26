package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Geometry extends Application {

    public static void messageDialog(String infoMessage, String titleBar, String headerMessage) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();
        Platform.exit();
    }

    public static double inputDialog(String infoMessage, String titleBar, String headerMessage) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle(titleBar);
        dialog.setHeaderText(headerMessage);
        dialog.setContentText(infoMessage);
        // Traditional way to get the response value.
        return Double.parseDouble(dialog.showAndWait().get());
    }

    public static void createCircle(Group root, double centerX, double centerY, double radius){
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(null);
        circle.setStroke(Color.RED);
        root.getChildren().add(circle);
    }

    public static void drawCrossPointsCircles(Group root, double xCoordinateOfAB, double yCrossPointOne, double yCrossPointTwo){
        Circle firstCircle = new Circle(xCoordinateOfAB, yCrossPointOne, 5);
        firstCircle.setStroke(Color.RED);
        root.getChildren().add(firstCircle);

        Circle secondCircle = new Circle(xCoordinateOfAB, yCrossPointTwo, 5);
        secondCircle.setStroke(Color.RED);
        root.getChildren().add(secondCircle);
    }

    public static void drawCoordinates(Group root, double xCoordinateOfAB, double yCrossPointOne, double yCrossPointTwo){
        Text firstCircleCoordinatesText = new Text(xCoordinateOfAB + 15, yCrossPointOne, String.format("[%.2f, %.2f]", xCoordinateOfAB, yCrossPointOne));
        root.getChildren().add(firstCircleCoordinatesText);

        Text secondCircleCoordinatesText = new Text(xCoordinateOfAB + 15, yCrossPointTwo, String.format("[%.2f, %.2f]", xCoordinateOfAB, yCrossPointTwo));
        root.getChildren().add(secondCircleCoordinatesText);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Group root = new Group();
        Scene scene = new Scene(root, 500, 500);

        double centerX = scene.getWidth() / 2;
        double centerY = scene.getHeight() / 2;

        double radius = Math.min(scene.getHeight(), scene.getWidth()) / 3;

        createCircle(root, centerX, centerY, radius);

        double xCoordinateOfAB = inputDialog("Enter x coordinate of line AB:", "Enter x coordinate", null);

        if(xCoordinateOfAB < 0 || xCoordinateOfAB > scene.getWidth()){
            messageDialog("Value of x coordinate isn't in right range!", "Warning", "Wrong value of x");
        }

        Line line = new Line(xCoordinateOfAB, 0, xCoordinateOfAB, scene.getHeight());
        line.setStroke(Color.BLUE);
        root.getChildren().add(line);

        double discriminant = radius * radius - (centerX - xCoordinateOfAB) * (centerX - xCoordinateOfAB);

        if(discriminant >= 0){
            double height = Math.sqrt(discriminant);
            double yCrossPointOne = centerY - height;
            double yCrossPointTwo = centerY + height;

            drawCrossPointsCircles(root, xCoordinateOfAB, yCrossPointOne, yCrossPointTwo);

            drawCoordinates(root, xCoordinateOfAB, yCrossPointOne, yCrossPointTwo);

        }
        else{
            messageDialog("There are no intersection points with circle!", "Warning", "No intersection points");
        }


        primaryStage.setTitle("Circle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
