package Game;

import java.util.ArrayList;
import java.awt.Point;

public class I extends Shape {
    
    private static ArrayList<Point> coordinates = new ArrayList<>(); // working
    // create the coordinates of the L shape
    static {
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(7, 1));
        coordinates.add(new Point(7, 2));
        coordinates.add(new Point(7, 3));
        // add coordinates to the list
    }
    public I() {
        // add points to the coordinates list
        // then user the super constructor to create the shape
        super(coordinates);
    }

    @Override
    public String toString() {
        return "I";
    }
}
