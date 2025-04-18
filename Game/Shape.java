package Game;
import java.awt.Point;
import java.util.ArrayList;

public class Shape {
    private ArrayList<Point> coordinates;

    public Shape(ArrayList<Point> coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Returns the coordinate positions of the shape.
     * 
     * @return array of coordinates of the shape.
     */
    public ArrayList<Point> getCoordinates() {
        return coordinates;
    }

    public 

    /**
     * Moves the shape left by one block.
     * 
     */
    public void moveLeft() {
        for (Point p : coordinates) {
            p.x--;
        }
    }

    public void moveRight() {
        for (Point p : coordinates) {
            p.x++;
        }
    }

    /**
     * Moves the shape down by one block.
     */
    public void moveDown() {
        for (Point p : coordinates) {
            p.y--;
        }
    }

    public void shootDown(int x, int y) { // the y axis is inverted
        for (Point p : coordinates) {
            p.y += y;
            p.x += x;
        }

    }
}