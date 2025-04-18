package Game;

import java.awt.Point;

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

    public static String[][] getBoard() {
        return board;
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

    // public static boolean isGameOver() {
    //     for (int i = 0; i < board[j].length; i++) {
    //         for (int j = 0; j < board.length; j++) {
    //             if(board[i][j].toString().equals("[]")
    //             }
    //         }
    //     }
    // }

    /**
     * Adds a new block to the board using a randomly generated shape from the Shape class.
     * 
     */
    public static void addNewShape() {}

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
    public static boolean canMoveDown() {
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
    public static boolean isRowFull(int y) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][y].toString().equals(" .")) {
                return false;
            }
        }
        return true;

    }


    // this method should use isRowFull() to check if the row is full
    // if the row is full then all of the blocks in the row should be replaced by the ones above it
    // this method should move from the bottom of the board (when y is at max) to the top of the board (min y)
    public static void clearFullLines() {
        for (int i = board.length - 2; i >= 0; i--) {       // good job copilot
            boolean fullLine = true;
            int fullLoc;
            for (int j = 1; j < board[i].length - 1; j++) {
                if (board[i][j].toString().equals(" .")) {
                    fullLine = false;
                    break;
                }
            }
            if (fullLine) {
                fullLoc = i;
                for (int k = fullLoc; k < board.length - 1; k++) {
                    board[k] = board[k + 1];
                }
            }
            
            // if (fullLine) {                      // im not so sure about this part
            //     fullLines++;
            //     for (int k = i; k < board.length - 1; k++) {
            //         board[k] = board[k + 1];
            //     }
            //     board[board.length - 1] = new Block[board[0].length];
            //     for (int j = 0; j < board[board.length - 1].length; j++) {
            //         if (j == 0) {
            //             board[board.length - 1][j] = new Block("<");
            //         } else if (j == board[board.length - 1].length - 1) {
            //             board[board.length - 1][j] = new Block(">");
            //         } else {
            //             board[board.length - 1][j] = new EmptyBlock();
            //         }
            //     }
            // }
        }
    }
}