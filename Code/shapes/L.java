package code.shapes;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Filename: L.java
 * 
 * @author Tina Hague
 * @version 1.0
 * @since 1.0
 * 
 * Last Updated: 5 May 2025
 */
public class L extends Shape {

    private static ArrayList<Point> coordinates = new ArrayList<Point>();
    static {
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(7, 1));
        coordinates.add(new Point(7, 2));
        coordinates.add(new Point(8, 2));
    }

    /**
     * Creates a new L shape.
     */
    public L() {
        super(coordinates);
    }
    
    @Override
    /**
     * String representation of the shape.
     */
    public String toString() {
        return "L";
    }
}
