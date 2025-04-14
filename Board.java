public class Board extends Shape {
    private Block[][] board;
    private int fullLines;

    public Board() {
        board = new Block[22][14];
        fullLines = 0;

        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == board.length - 1) { // the bottom row
                    if (j == 0 || j == board[i].length - 1) {
                        board[i][j] = new Block(i, j, "  ");
                    }
                    else board[i][j] = new Block(i, j, " \\/");
                }
                else if (j == 1) { // the "! "
                    board[i][j] = new Block(i, j, "! ");
                }
                else if (j == board[i].length - 2) { // the "!"
                    board[i][j] = new Block(i, j, "!");
                }
                else if (j == board[i].length - 1) { // the righmost column
                    board[i][j] = new Block(i, j, ">");
                }
                else if (j == 0) { // the leftmost column
                    board[i][j] = new Block(i, j, "<");
                }
                else { // everything inbetween
                    board[i][j] = new EmptyBlock(i, j);
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
    public boolean hasBlock(int x, int y) {
        if (!board[x][y].toString().contains(".")) {
            return true;
        }
        else {
            return false;
        }
    }

    public void clearFullLines() {
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