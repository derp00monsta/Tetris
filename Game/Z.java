package Game;

import java.util.ArrayList;
import java.awt.Point;

public class Z extends Shape { //working
    
    private static ArrayList<Point> coordinates = new ArrayList<>();
    // create the coordinates of the L shape
    static {
        coordinates.add(new Point(6, 0));
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(8, 1));
        coordinates.add(new Point(7, 1));
        // add coordinates to the list
    }
    public Z() {
        // add points to the coordinates list
        // then user the super constructor to create the shape
        super(coordinates);
    }

    @Override
    public String toString() {
        return "Z";
    }
}
