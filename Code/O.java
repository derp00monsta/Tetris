package Code;

import java.util.ArrayList;
import java.awt.Point;

/**
 * Filename: O.java
 * 
 * @author Tina Hague
 * @version 1.0
 * @since 1.0
 * 
 * Last updated: 2 May 2025
 */
public class O extends Shape {
    private static ArrayList<Point> coordinates = new ArrayList<>();
    static {
        coordinates.add(new Point(6, 0));
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(7, 1));
        coordinates.add(new Point(6, 1));
    }

    /**
     * Create a new O shape.
     */
    public O() {
        super(coordinates);
    }

    @Override
    /**
     * String representation of the shape.
     */
    public String toString() {
        return "O";
    }
}
