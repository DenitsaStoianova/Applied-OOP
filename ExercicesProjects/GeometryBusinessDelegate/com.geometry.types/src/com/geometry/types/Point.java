package com.geometry.types;

public class Point implements Shape {

    private int x;
    private int y;

    public Point(int x, int y) {
       setX(x);
       setY(y);
    }

    public Point(){
        this(0,0);
    }

    public Point(Point point){
        this(point.x, point.y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {

        if(o == null){
            return 1;
        }

        if(!(o instanceof Point)){
            return 1;
        }

        Point other = (Point)o;

        if(this.x != other.x){
            return this.x - other.x;
        }

        return this.y - other.y;
    }

    @Override
    public String toString() {
        return String.format("{Point: (%d, %d)}", this.x, this.y);
    }
}
