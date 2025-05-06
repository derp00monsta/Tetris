package shapes;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Filename: J.java
 * 
 * @author Tina Hague
 * @version 1.0
 * @since 1.0
 * 
 * Last Updated: 5 May 2025
 */
public class J extends Shape {
    private static ArrayList<Point> coordinates = new ArrayList<Point>();
    static {
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(7, 1));
        coordinates.add(new Point(7, 2));
        coordinates.add(new Point(6, 2));
    }

    /**
     * Creates a new J shape.
     */
    public J() {
        super(coordinates);
    }

    /**
     * String representation of the shape.
     */
    public String toString() {
        return "J";
    }
}
