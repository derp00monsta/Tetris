package Game;

import java.awt.Point;
import java.util.ArrayList;

public class L extends Shape {

    private static ArrayList<Point> coordinates = new ArrayList<>();
    // create the coordinates of the L shape
    static {
        // add coordinates to the list
    }
    public L() {
        // add points to the coordinates list
        // then user the super constructor to create the shape
        super(coordinates);
    }
    
    
}
