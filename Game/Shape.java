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

    /**
     * Moves the shape left by one block.
     * 
     */
    public void moveLeft() {
        for (int i = 0; i < coordinates.size(); i++) {
            int x = (int) coordinates.get(i).getX() - 1;
            int y = (int) coordinates.get(i).getY();
            coordinates.get(i).setLocation(x, y);
            System.out.println(coordinates.get(i));
        }
    }

    /**
     * Moves the shape right by one block.
     * 
     */
    public void moveRight() {
        for (int i = 0; i < coordinates.size(); i++) {
            int x = (int) coordinates.get(i).getX() + 1;
            int y = (int) coordinates.get(i).getY();
            coordinates.get(i).setLocation(x, y);
        }
    }

    /**
     * Moves the shape down by one block.
     */
    public void moveDown() {
        for (int i = 0; i < coordinates.size(); i++) {
            int x = (int) coordinates.get(i).getX();
            int y = (int) coordinates.get(i).getY() + 1;
            coordinates.get(i).setLocation(x, y);
        }
    }
}