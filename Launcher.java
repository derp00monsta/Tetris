

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
        System.out.println("Welcome to Tetris!");
        System.out.println("To play, it is best to extend your terminal.");
        addDelay();
        System.out.println("Are you ready to play? (yes/no)");
        String input;
        boolean startGame = false;

        // after each move, 
        
        while(true) {
            input = scanner.nextLine();
            if (input.equals("yes")){
                startGame = true;
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

            // add a shape to the board
            Board.addNewShape();
            Board.printBoard();
            // print the board

            while (true) {
                System.out.println("Which way would you like to move the block?");
                System.out.println("l -> left, r -> right, s -> shoot down, q -> quit");
                try {
                    input = scanner.nextLine();
                    break;
                }
                catch (Exception e) {
                    System.out.println("Please enter a valid input (ie l, r, s, q).");
                }
            }

            switch (input) {
                case "l":
                    Board.moveLeft();
                    break;
                case "r":
                    Board.moveRight();
                    break;
                case "s":
                    Board.shootShapeDown();
                    break;
                case "q":
                    System.out.println("Have a lovely day!");
                    System.exit(0);
                    break;
            }
            Board.clearFullLines(); 

        

    
        
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