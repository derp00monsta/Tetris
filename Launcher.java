

import java.util.Scanner;

import javax.swing.SwingUtilities;

import Game.Board;
import Swing.StartMenu;

public class Launcher {
    public static void main(String[] args) {
        // SwingUtilities.invokeLater(new Runnable() {
        //     @Override
        //     public void run() {
        //         StartMenu menu = new StartMenu();
        //         //ControlsDisplay controls = new ControlsDisplay();
        //         //GameDisplay game = new GameDisplay();
        //         menu.setVisible(true);
        //     }
        // });
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        Board.clearScreen();
        System.out.println("Welcome to Tetris!");
        System.out.println("To play, it is best to extend your terminal.");
        addDelay();
        System.out.println("Are you ready to play? (yes/no)");
        String input;
        boolean lost = false;
        Board.addNewShape();

        // after each move, 
        
        while(true) {
            input = scanner.nextLine();
            if (input.equals("yes")){
                break;
            }
            else if (input.equals("no")) {
                System.out.println("Have a lovely day!");
                System.exit(0);
            }
            else {
                System.out.println("Please enter 'yes' or 'no'.");
            }
        }

        Board.clearScreen();

            Board.printBoard();
            // print the board

            while (!lost) {
               // Board.clearScreen();
                //Board.printBoard();
                System.out.println("Which way would you like to move the block?");
                System.out.println("l -> left");
                System.out.println("r -> right");
                System.out.println("s -> shoot down");
                System.out.println("q -> quit");
                while(true) {
                    input = scanner.nextLine();
                    if (input.equals("l") || input.equals("r") || input.equals("s") || input.equals("q")) {
                        break;
                    }
                    else {
                        System.out.println("Please enter valid input (l, r, s, q)");
                    }
                }

                switch (input) { // y = 7 or 8
                    case "l":
                        try{
                            Board.moveLeft();
                        }
                        catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "r":
                        try {
                            Board.moveRight();
                        }
                        catch(Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case "s":
                        Board.shootShapeDown();
                        break;
                    case "q":
                        System.out.println("Have a lovely day!");
                        System.exit(0);
                        break;
                }
                Board.clearScreen();
                Board.moveDown();
               // while (!Board.canMoveDown()) {
                    Board.addNewShape();

                //}
                //Board.clearFullLines(); 
                // if (!Board.canMoveDown()) {
                //     Board.addNewShape(); // some of the shapes do not work, print them to find which ones dont work
                //     //System.out.println("New shape");
                // }
                System.out.println(Board.canMoveDown());
                Board.printBoard();
                lost = Board.isGameOver() ? true : false;
            }


            //continue logic to prevent infinite game loop and end the game

        

    
        
    }

    /**
     * Add a delay to the program for a specified duration.
     */
    private static void addDelay() {
        addDelay(600);
    }

    /**
     * Add a delay to the program for a specified duration.
     * 
     * @param duration to delay the program for in milliseconds.
     */
    private static void addDelay(long duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}