package geometry;


import java.util.Arrays;

public class Point {

    private int[] coordinates; // x and y coordinates

    public Point(int[] coordinates) {
        setCoordinates(coordinates);
    }

    public Point() {
        this(new int[2]); // reference to public Point(double[] coordinates), default value => x = 0 and y = 0
    }

    public Point(Point point) {
        this(point.coordinates); // reference to public Point(double[] coordinates)
    }

    public int[] getCoordinates() { // return deep copy
        int[] coordinatesCopy = new int[coordinates.length];
        for(int i = 0; i < coordinatesCopy.length; i++){
            coordinatesCopy[i] = this.coordinates[i];
        }
        return coordinatesCopy; // return copy of original array
    }

    public void setCoordinates(int[] coordinates) {
        if(coordinates != null && coordinates.length == 2){ // if is valid => deep copy
            this.coordinates = new int[2];
            for(int i = 0; i < coordinates.length; i++){
                this.coordinates[i] = coordinates[i];
            }
        }
        else{ // not valid
            this.coordinates = new int[]{0,0}; // default value => x = 0 and y = 0
        }
    }

    @Override
    public String toString() {
        /*
        String result = "";
        for(int i = 0; i < coordinates.length; i++){
            result += String.format("double[%d] = %.2f\n", i, coordinates[i]);
        }
        */
        return String.format("(%d; %d)", coordinates[0], coordinates[1]); // x ad y coordinates
    }
}
