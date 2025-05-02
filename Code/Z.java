package Code;
import java.util.ArrayList;
import java.awt.Point;

/**
 * Filename: Z.java
 * 
 * @author Tina Hague
 * @version 1.0
 * @since 1.0
 * 
 * Last updated: 2 May 2025
 */
public class Z extends Shape {
    
    private static ArrayList<Point> coordinates = new ArrayList<>();
    static {
        coordinates.add(new Point(6, 0));
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(8, 1));
        coordinates.add(new Point(7, 1));
    }

    /**
     * Creates a new Z shape.
     */
    public Z() {
        super(coordinates);
    }

    /**
     * String representation of the shape.
     */
    @Override
    public String toString() {
        return "Z";
    }
}
