package view;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Light;
import javafx.scene.layout.Pane;

public class MainSceneController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDrawLine;

    @FXML
    private Button btnDrawrRectangle;

    @FXML
    private Pane pnlDrawingBoard;

    private Random generator = new Random();

    @FXML
    void btnDrawLineOnAction(ActionEvent event) {
        int[] coordinates = new int[]{generator.nextInt((int) pnlDrawingBoard.getWidth()), // x coordinate
                generator.nextInt((int) pnlDrawingBoard.getHeight())}; // y coordinate

        Point point2 = new Point(new int[]{generator.nextInt((int) pnlDrawingBoard.getWidth()), // x coordinate
                generator.nextInt((int) pnlDrawingBoard.getHeight())}); // y coordinate)

        Line line = new Line(coordinates, point2);
        line.draw(pnlDrawingBoard);
    }

    @FXML
    void btnDrawrRectangleOnAction(ActionEvent event) {

        int width = (int) pnlDrawingBoard.getWidth();
        int height = (int) pnlDrawingBoard.getHeight();

        int[] coordinates = new int[]{generator.nextInt((int) pnlDrawingBoard.getWidth() - 1), // x coordinate
                generator.nextInt((int) pnlDrawingBoard.getHeight() - 1)}; // y coordinate

        Point point2;

        int x = 0, y = 0;

        do {
            x = generator.nextInt(width);
        } while(x <= coordinates[0]); // check if rectangle is on pane, if not generate new value

        do {
            y = generator.nextInt(height);
        } while(y <= coordinates[1]);

        point2 = new Point(new int[]{x, y});
        Rectangle rectangle = new Rectangle(coordinates, point2);

        //System.out.println(Arrays.toString(coordinates) + p2.toString() + "\n" + r.measure());
        rectangle.draw(pnlDrawingBoard);
    }

    @FXML
    void initialize() {
        assert btnDrawLine != null : "fx:id=\"btnDrawLine\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert btnDrawrRectangle != null : "fx:id=\"btnDrawrRectangle\" was not injected: check your FXML file 'MainScene.fxml'.";
        assert pnlDrawingBoard != null : "fx:id=\"pnlDrawingBoard\" was not injected: check your FXML file 'MainScene.fxml'.";

    }
}
