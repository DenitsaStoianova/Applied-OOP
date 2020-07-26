package com.geometry.types;

public class Cylinder extends Circle {

    private int height;

    public Cylinder(int x, int y, int radius, int height) {
        super(x, y, radius);
        setHeight(height);
    }

    public Cylinder(){
        this(0,0,1,1);
    }

    public Cylinder(Cylinder cylinder){
        this(cylinder.getX(), cylinder.getY(), cylinder.getRadius(), cylinder.height);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height <= 0 ? 1 : height;
    }

    @Override
    public int compareTo(Object o){

        if(o == null){
            return 1;
        }
        if(!(o instanceof Cylinder)){
            return 1;
        }

        Cylinder other = (Cylinder) o; // downcast

        if(super.compareTo(other) != 0){
            return super.compareTo(other);
        }

        return this.height - other.height;
    }

    @Override
    public String toString() {
        return String.format("{Cylinder: %d, %s}", this.height, super.toString());
    }
}
