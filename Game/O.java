package Game;

import java.util.ArrayList;
import java.awt.Point;

public class O extends Shape {

    private static ArrayList<Point> coordinates = new ArrayList<>();
    // create the coordinates of the L shape
    static {
        // add coordinates to the list
    }
    public O() {
        // add points to the coordinates list
        // then user the super constructor to create the shape
        super(coordinates);
    }
}
