package code.shapes;

import java.util.ArrayList;
import java.awt.Point;

/**
 * Filename: S.java
 * 
 * @author Tina Hague
 * @version 1.0
 * @since 1.0
 * 
 * Last updated: 5 May 2025
 */
public class S extends Shape {
    private static ArrayList<Point> coordinates = new ArrayList<Point>();
    static {
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(7, 1));
        coordinates.add(new Point(8, 0));
        coordinates.add(new Point(6, 1));
    }

    /**
     * Creates a new S shape.
     */
    public S() {
        super(coordinates);
    }

    /**
     * String representation of the shape.
     */
    public String toString() {
        return "S";
    }
}
