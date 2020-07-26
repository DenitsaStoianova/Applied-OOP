package com.geometry.utils;

import com.geometry.types.Circle;
import com.geometry.types.Cylinder;
import com.geometry.types.Point;

import java.util.Random;

public class SelectionSortTest {

    private static Comparable[] arrComparable;

    public static void main(String[] args) {
        arrComparable = new Comparable[9];
        Random generator = new Random();

        for(int i = 0; i < 3; i++){
            int x = generator.nextInt(41) + 10;
            int y = generator.nextInt(41) + 10;

            arrComparable[i] = new Point(x,y);
        }

        for(int i = 3; i < 6; i++){
            int radius = generator.nextInt(21) + 10;

            Point point = ((Point)arrComparable[i-3]);
            arrComparable[i] = new Circle(point.getX(),point.getY(), radius);
        }

        for(int i = 6; i < 9; i++){
            int height = generator.nextInt(51) + 10;

            Circle circle = ((Circle)arrComparable[i - 3]);
            arrComparable[i] = new Cylinder(circle.getX(), circle.getY(), circle.getRadius(), height);
        }

        for(int i = 0; i < arrComparable.length; i++){
            System.out.println(arrComparable[i]);
        }

        SelectionSort.sortArray(arrComparable);

        System.out.println("\nSorted");
        for(int i = 0; i < arrComparable.length; i++){
            System.out.println(arrComparable[i]);
        }
    }
}
