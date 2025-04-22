package Game;

import java.util.ArrayList;
import java.awt.Point;

public class S extends Shape {
    
    private static ArrayList<Point> coordinates = new ArrayList<>(); //working
    // create the coordinates of the L shape
    static {
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(7, 1));
        coordinates.add(new Point(8, 0));
        coordinates.add(new Point(6, 1));
        // add coordinates to the list
    }
    public S() {
        // add points to the coordinates list
        // then user the super constructor to create the shape
        super(coordinates);
    }
}
