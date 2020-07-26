package com.geometry.types;

public class Circle extends Point {
    private int radius;

    public Circle(int x, int y, int radius) {
        super(x, y);
        setRadius(radius);
    }

    public Circle(){
        this(0,0,0);
    }

    public Circle(Circle circle){
        this(circle.getX(), circle.getY(), circle.radius);
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius <= 0 ? 1 : radius;
    }

    @Override
    public int compareTo(Object o){

        if(o == null){
            return 1;
        }
        if(!(o instanceof Circle)){
            return 1;
        }

        Circle other = (Circle) o; // downcast

        if(super.compareTo(other) != 0){
            return super.compareTo(other);
        }

        return this.radius - other.radius;
    }

    @Override
    public String toString() {
        return String.format("{Circle: %d, %s}", this.radius, super.toString());
    }
}
