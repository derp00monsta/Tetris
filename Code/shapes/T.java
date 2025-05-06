package code.shapes;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Filename: T.java
 * 
 * @author Tina Hague
 * @version 1.0
 * @since 1.0
 * 
 * Last updates: 5 May 2025
 */
public class T extends Shape {
    private static ArrayList<Point> coordinates = new ArrayList<Point>();
    static {
        coordinates.add(new Point(6, 0));
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(8, 0));
        coordinates.add(new Point(7, 1));
    }

    /**
     * Creates a new T shape.
     */
    public T() {
        super(coordinates);
    }

    /**
     * String representation of the shape.
     */
    public String toString() {
        return "T";
    }
    
}
