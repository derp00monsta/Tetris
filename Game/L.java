package Game;

import java.awt.Point;
import java.util.ArrayList;

public class L extends Shape {

    private static ArrayList<Point> coordinates = new ArrayList<>();
    // create the coordinates of the L shape
    static {
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(7, 1));
        coordinates.add(new Point(7, 2));
        coordinates.add(new Point(8, 2));
        // add coordinates to the list
    }
    public L() {
        // add points to the coordinates list
        // then user the super constructor to create the shape
        super(coordinates);
    }
    
    
}
