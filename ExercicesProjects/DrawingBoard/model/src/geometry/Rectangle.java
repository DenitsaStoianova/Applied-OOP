package geometry;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Rectangle extends Point{

    private Point lPoint; // upper left corner x and y coordinates

    public Rectangle(int[] coordinates, Point lPoint) {
        super(coordinates);
        setlPoint(lPoint);
    }

    public Rectangle() {
        this(new int[]{0,0}, new Point(new int[]{10,10}));
    }

    public Rectangle(Rectangle rectangle) {
        this(rectangle.getCoordinates(), rectangle.lPoint); // copy from new Line class
    }

    public Point getlPoint() {
        return new Point(lPoint);
    }

    public void setlPoint(Point lPoint) {// deep copy and check with copy constructor
        this.lPoint = new Point(lPoint);
    }

    public int measure(){
        int width = Math.abs(super.getCoordinates()[0] - lPoint.getCoordinates()[0]); // get x coordinate
        int height = Math.abs(super.getCoordinates()[1] - lPoint.getCoordinates()[1]); // get y coordinate
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("Upper left point: %s \nUpper right point: %s ", super.toString(), lPoint.toString());
    }

    public void draw(Pane pane){

        int width = Math.abs(super.getCoordinates()[0] - lPoint.getCoordinates()[0]); // get x coordinate
        int height = Math.abs(super.getCoordinates()[1] - lPoint.getCoordinates()[1]); // get y coordinate

        // to get Rectangle from javaFX, not current class
        javafx.scene.shape.Rectangle rectangle =
                new javafx.scene.shape.Rectangle(super.getCoordinates()[0], super.getCoordinates()[1], width, height);

        rectangle.setStroke(Color.BLUE);
        rectangle.setFill(null);

        pane.getChildren().add(rectangle);
    }
}
