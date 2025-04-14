package Game;
import java.awt.Point;

public class Block {
    private String block;
    private Point position;
    
    /**
     * Constructor for Block class.
     * 
     * @param x
     * @param y
     */
    public Block(int x, int y) {
        block = "[]";
        position = new Point(x, y);
    }

    /**
     * Constructor for Block class.
     * 
     * @param x
     * @param y
     * @param symbol
     */
    public Block(int x, int y, String symbol) {
        block = symbol;
        position = new Point(x, y);
    }

    /**
     * Returns the string representation of the block.
     * 
     * @return the string representation of the block.
     */
    public String toString() {
        return block;
    }

    /**
     * Returns the position of the block.
     * 
     * @return the position of the block as a Point object.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Moves a shapes down by one block.
     * 
     * @return the new position of the block after moving down.
     */
    public Point moveDown() { // the y-axis is inverted in the board
        position.y++;
        return position;
    }

    /**
     * Moves a shape left by one block.
     * 
     * @return the new position of the block after moving left.
     */
    public Point moveLeft() {
        position.x--;
        return position;
    }

    /**
     * Moves a shape right by one block.
     * 
     * @return the new position of the block after moving right.
     */
    public Point moveRight() {
        position.x++;
        return position;
    }

    /**
     * Shoots the block down until it hits something.
     * 
     * @param below the block below the current block.
     * @return the new position of the block after shooting down.
     */
    public Point shootDown(Point below) {
        while (position.y < below.y) {
            position.y++;
        }
        return position;
    }
}
