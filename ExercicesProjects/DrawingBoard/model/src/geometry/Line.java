package geometry;


import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Line extends Point{

    private Point ePoint; // end x nad y coordinates of line

    public Line(int[] coordinates, Point ePoint) {
        super(coordinates); // always call at first line of constructor
        setePoint(ePoint);
    }

    public Line() {
        this(new int[]{0,0}, new Point(new int[]{10,10})); // to get full line
    }

    public Line(Line line) {
        this(line.getCoordinates(), line.ePoint); // copy from new Line class
    }

    public Point getePoint() {
        return new Point(ePoint);
    }

    public void setePoint(Point ePoint) {
        this.ePoint = new Point(ePoint);
    }

    @Override
    public String toString() {
        return String.format("Starting point coordinates: %s\nEnding point coordinates: %s\n", super.toString(), ePoint);
    }

    public double measure() {
        return Math.sqrt((super.getCoordinates()[0] - ePoint.getCoordinates()[0]) *
                (super.getCoordinates()[0] - ePoint.getCoordinates()[0]) +
                (super.getCoordinates()[1] - ePoint.getCoordinates()[1]) *
                        (super.getCoordinates()[1] - ePoint.getCoordinates()[1]));
    }

    public void draw(Pane pane){ // use direct window to draw
        // to get Line from javaFX, not current class
        javafx.scene.shape.Line line =
                new javafx.scene.shape.Line(super.getCoordinates()[0], super.getCoordinates()[1],
                        ePoint.getCoordinates()[0], ePoint.getCoordinates()[1]);

        line.setStroke(Color.RED);
        line.setStrokeWidth(2);
        pane.getChildren().add(line);

    }
}
