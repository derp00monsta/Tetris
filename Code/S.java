package Code;

import java.util.ArrayList;
import java.awt.Point;

/**
 * Filename: S.java
 * 
 * @author Tina Hague
 * @version 1.0
 * @since 1.0
 * 
 * Last updated: 2 May 2025
 */
public class S extends Shape {
    private static ArrayList<Point> coordinates = new ArrayList<>();
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

    @Override
    /**
     * String representation of the shape.
     */
    public String toString() {
        return "S";
    }
}
