package Code;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Filename: Board.java
 * 
 * @author Tina Hague
 * @version 1.0
 * @since 1.0
 * 
 * Last Updated: 2 May 2025
 */
public class Board {
    private static Shape activeShape;
    private static String[][] board;
    private static int fullLines;
    private static boolean switchShape;
    private static boolean gameOver;


    /**
     * Creates a Tetris board.
     */
    public Board() {
        board = new String[22][14];
        fullLines = 0;
        switchShape = true;
        gameOver = false;
        setBoard();
    }

    /**
     * Sets the template for the Tetris environment.
     */
    public static void setBoard() {
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == board.length - 1) { 
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
                else if (j == 1) { 
                    board[i][j] = "!";
                }
                else if (j == board[i].length - 2) { 
                    board[i][j] = "!";
                }
                else if (j == board[i].length - 1) { 
                    board[i][j] = ">";
                }
                else if (j == 0) { 
                    board[i][j] = "<";
                }
                else { 
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
        if (board[y][x].toString().equals(" .")) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Prints the board to the console.
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
    public static boolean isGameOver() {
        return !canFitNewShape();
    }

    /**
     * Checks if the column is full.
     * 
     * @param x the column to check
     * @return whether or not the column is full
     */
    private static boolean isColumnFull(int x) {
        for (int i = 0; i < board.length; i++) {
            if (!board[i][x].equals("[]")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds a new block to the board using a randomly generated shape from the Shape class.
     */
    public static void addNewShape() { 
        int i = 0;
        while (!canMoveDown() && canFitNewShape()) { //definetly infinite
            activeShape = generateShape();
            show();
            i++;
        }
    }
    
    private static boolean canFitNewShape() { 
        for (String str : board[4]) {
            if (str.equals("[]")) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks to see if the shape is at the top of the board.
     * 
     * @return whether or not the shape is at the top of the board.
     */
    private static boolean atTop() {
        int y = (int) activeShape.getCoordinates().get(0).getY();
        if (y == 0) {
            return true;
        }
        return false;
    }

    /**
     * Generates a random shape.
     * 
     * @return a random shape.
     */
    private static Shape generateShape() {
        int randomNum = (int) (Math.random() * 7);
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
            default:
                shape = new O();
        }
        return shape;
    }

    /**
     * Makes the new shape visible.
     */
    public static void show() {
        for (Point point : activeShape.getCoordinates()) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            board[y][x] = "[]"; 
        }
    }

    /**
     * Flashes the board display.
     */
    public static void flash() {
        printBoard();
        addDelay(150);
        clearScreen();
        addDelay(150);
        printBoard();
        addDelay(150);
        clearScreen();
        addDelay(150);
        printBoard();
    }

    /**
     * Refreshes the location of the shape on the board.
     */
    public static void refreshPose(ArrayList<Point> old) {
        for (Point point : old) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            board[y][x] = " .";
        }

        for (Point point : activeShape.getCoordinates()) {
            int x = (int) point.getX();
            int y = (int) point.getY();
            board[y][x] = "[]"; 
        }
    }

    /**
     * Moves the shape down by one block.
     */
    public static void moveDown() {
        if (canMoveDown()) {
            activeShape.moveDown();
        }
    }

    /**
     * Moves the shape left by one block and refreshes the board.
     */
    public static void moveLeft() throws Exception {
        if (!canMoveLeft()) {
            throw new Exception("You can not move left anymore.");
        }
        else {
            ArrayList<Point> old = new ArrayList<Point>();
            for (Point p : activeShape.getCoordinates()) {
                int x = (int) p.getX();
                int y = (int) p.getY();
    
                old.add(new Point(x, y));
            }
            activeShape.moveLeft(); 
            refreshPose(old);
        }
    }

    /**
     * Moves the shape right by one block and refreshes the board.
     */
    public static void moveRight() throws Exception {
        if (!canMoveRight()) {
            throw new Exception("You can not move right anymore.");
        } 
        ArrayList<Point> old = new ArrayList<Point>();
        for (Point p : activeShape.getCoordinates()) {
            int x = (int) p.getX();
            int y = (int) p.getY();

            old.add(new Point(x, y));
        }
        activeShape.moveRight(); 
        activeShape.moveDown();
        refreshPose(old);
    }

    /**
     * Changes coordinates of the shape and refreshes the board.
     */
    public static void shootShapeDown() {
        while (canMoveDown()) {
            clearScreen();
            ArrayList<Point> old = new ArrayList<Point>();
            for (Point p : activeShape.getCoordinates()) {
                int x = (int) p.getX();
                int y = (int) p.getY();
    
                old.add(new Point(x, y));
            }
            activeShape.moveDown();
            refreshPose(old);
            printBoard();
            addDelay(200);
        }
    }

    /**
     * Checks if the shape can move down by one block.
     * 
     * @return whether or not the shape can move down.
     */
    public static boolean canMoveDown() {
        int x;
        int y;
        if (activeShape == null) {
            return false;
        }
        for (Point p : activeShape.getCoordinates()) {
            x = (int) p.getX();
            y = (int) p.getY();
            if (y == activeShape.getBottomEdge() && hasBlock(x, y + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the shape can move right by one block.
     * 
     * @return whether or not the shape can move right.
     */
    private static boolean canMoveRight() { 
        int x;
        int y;
        for (Point p : activeShape.getCoordinates()) {
            x = (int) p.getX();
            y = (int) p.getY();
            if (x == activeShape.getRightEdge() && hasBlock(x + 1, y)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the shape can move left by one block.
     * 
     * @return whether or not the shape can move left.
     */
    private static boolean canMoveLeft() { 
        int x;
        int y;
        for (Point p : activeShape.getCoordinates()) {
            x = (int) p.getX();
            y = (int) p.getY();
            if (x == activeShape.getLeftEdge() && hasBlock(x - 1, y)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the row is full.
     * 
     * @param y the y coordinate position of the row.
     * @return whether the row is full or not.
     */
    private static boolean isRowFull(int y) {
        for (int i = 0; i < board[y].length; i++) {
            if (board[y][i].toString().equals(" .")) {
                return false;
            }
        }
        return true;

    }

    /**
     * Shifts all blocks that are above row y to clear the full lines
     * 
     * @param y the row that must be cleared
    */
    private static void clearLine(int y) {
        for (int i = y; i > 0; i--) {
            for (int j = 2; j < board[i].length - 2; j++) {
                if (board[i][j].equals("[]")) {
                    board[i][j] = board[i - 1][j];
                    board[i - 1][j] = " .";
                }

            }
        }
    }


    /**
     * Clears the lines that are full and updates the number of full lines created by the player
     */
    public static void clearFullLines() {
        int fullLines = 0;
        ArrayList<Integer> linesToClear = new ArrayList<Integer>();

        for (int i = 0; i < board.length; i++) {
            if (isRowFull(i)) {
                fullLines++;
                linesToClear.add(i);

            }
        }

        for (Integer row : linesToClear) {
            clearLine(row);
        }

        Board.fullLines = fullLines;
    }

    /**
     * Add a delay to the program for a specified duration.
     */
    public static void addDelay() {
        addDelay(600);
    }

    /**
     * Add a delay to the program for a specified duration.
     * 
     * @param duration to delay the program for in milliseconds.
     */
    public static void addDelay(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}