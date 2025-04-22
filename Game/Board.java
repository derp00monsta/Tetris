package Game;

import java.awt.Point;
import java.util.ArrayList;

public class Board {
    private static Shape activeShape;
    private static String[][] board;
    private static int fullLines;

    public Board() {
        board = new String[22][14];
        fullLines = 0;

        setBoard();
    }

    public static void setBoard() {
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == board.length - 1) { // the bottom row
                    if (j == 0) {
                        board[i][j] = "  ";
                    }
                    else if (j < board[i].length - 3) {
                        board[i][j] = "\\/";
                    }
                    else {
                        board[i][j] = "  ";
                    }
                }
                else if (j == 1) { // the "! "
                    board[i][j] = "!";
                }
                else if (j == board[i].length - 2) { // the "!"
                    board[i][j] = "!";
                }
                else if (j == board[i].length - 1) { // the righmost column
                    board[i][j] = ">";
                }
                else if (j == 0) { // the leftmost column
                    board[i][j] = "<";
                }
                else { // everything inbetween
                    board[i][j] = " .";
                }
            }
        }
    }

    /**
     * Returns how many full lines the user has created.
     * 
     * @return how many full lines the user has created
     */
    public static int getFullLines() {
        return fullLines;
    }

    /**
     * Checks if the coordinate position contains a block.
     * 
     * @param x the x coordinate position
     * @param y the y coordinate position
     * @return whether the coordinate position contains a block or not.
     */
    public static boolean hasBlock(int x, int y) {
        if (board[x][y].toString().contains("[]")) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Prints the board to the console.
     * 
     */
    public static void printBoard() {
        System.out.println();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Clears the content displayed on the screen.
     * 
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    /**
     * Checks if there is a full column and the game is over.
     * 
     * @return whether or not the game has ended.
     */
    public static boolean isGameOver() { // recursion???? // how can you do this without a helper method?
        for (int j = 0; j < board[0].length; j++) {
            if (isColumnFull(j)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Checks if the column is full.
     * 
     * @param x the column to check
     * @return whether or not the column is full
     */
    private static boolean isColumnFull(int x) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][x].equals(" .")) {
                return false;
            }
        }
        return true;
    }
    /**
     * Adds a new block to the board using a randomly generated shape from the Shape class.
     * 
     */
    public static void addNewShape() {
        activeShape = generateShape();

    }

    /**
     * Checks if the active shape is settled and can not move any farther down.
     * 
     * @return whether or not the shape is settled
     */
    public static boolean isSettled() {
        for (Point loc : activeShape.getCoordinates()) {
            if (hasBlock((int) loc.getX(), (int) loc.getY() - 1)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Generates a random shape.
     * 
     * @return a random shape.
     */
    private static Shape generateShape() {
        int randomNum = (int) (Math.random() * 7); // generates a random number between 0 and 6
        Shape shape = null;

        switch(randomNum) {
            case 0:
                shape = new L();
                break;
            case 1:
                shape = new T();
                break;
            case 2:
                shape = new I();
                break;
            case 3:
                shape = new J();
                break;
            case 4:
                shape = new S();
                break;
            case 5:
                shape = new Z();
                break;
            case 6:
                shape = new O();
                break;
        }
        return shape;
    }

    /**
     * Refreshes the location of the shape on the board.
     * 
     */
    public static void refreshPose() {
        for (Point point : activeShape.getCoordinates()) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            board[x][y] = "[]"; // display the shape on the board
        }
    }

    /**
     * Moves the shape left by one block and refreshes the board.
     * 
     */
    public static void moveLeft() {
        activeShape.moveLeft(); // move the shape left by one block
        refreshPose();
    }

    /**
     * Moves the shape right by one block and refreshes the board.
     * 
     */
    public static void moveRight() {
        activeShape.moveRight(); // move the shape right by one block
        refreshPose();
    }

    /**
     * Changes coordinates of the shape and refreshes the board.
     * 
     */
    public static void shootShapeDown() {
        while (canMoveDown()) {
            activeShape.moveDown();
        }
        refreshPose();
    }

    /**
     * Checks if the shape can move down by one block.
     * 
     * @return whether or not the shape can move down.
     */
    private static boolean canMoveDown() {
        boolean canMoveDown = true;
        for (int i = 0; i < activeShape.getCoordinates().size(); i++) {
            int x = (int) activeShape.getCoordinates().get(i).getX();
            int y = (int) activeShape.getCoordinates().get(i).getY();
            if (hasBlock(x, y - 1)) {
                canMoveDown = false;
                break;
            }
        }
        return canMoveDown;
    }

    /**
     * Checks if the row is full.
     * 
     * @param y the y coordinate position of the row.
     * @return whether the row is full or not.
     */
    private static boolean isRowFull(int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[y][i].toString().equals(" .")) {
                return false;
            }
        }
        return true;

    }

    // this should shift all blocks above row y down
    /**
     * Shifts all blocks that are above row y to clear the full lines
     * 
     * @param y the row that must be cleared
    */
    private static void clearLine(int y) {
        for (int i = y; i > 0; i--) {
            for (int j = 2; j < board[i].length - 2; j++) {
                board[i][j] = board[i - 1][j];
                board[i - 1][j] = " .";
            }
        }
    }


    /**
     * Clears the lines that are full and updates the number of full lines created by the player
     * 
     */
    public static void clearFullLines() {
        int fullLines = 0; //used to move everything down by the number of lines cleared
        ArrayList<Integer> linesToClear = new ArrayList<Integer>();

        // check which lines should be cleared
        for (int i = 0; i < board.length; i++) {
            if (isRowFull(i)) {
                fullLines++;
                linesToClear.add(i);

            }
        }

        // clear the lines that are full
        for (Integer row : linesToClear) {
            clearLine(row);
        }

        Board.fullLines = fullLines;
    }
}