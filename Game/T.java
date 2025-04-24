package Game;

import java.awt.Point;
import java.util.ArrayList;

public class T extends Shape { //working
    private static ArrayList<Point> coordinates = new ArrayList<>();
    // create the coordinates of the L shape
    static {
        // add coordinates to the list
        coordinates.add(new Point(6, 0));
        coordinates.add(new Point(7, 0));
        coordinates.add(new Point(8, 0));
        coordinates.add(new Point(7, 1));
    }
    public T() {
        // add points to the coordinates list
        // then user the super constructor to create the shape
        super(coordinates);
    }

    @Override
    public String toString() {
        return "T";
    }
    
}
