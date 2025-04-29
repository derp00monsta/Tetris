

import java.util.Scanner;

import javax.swing.SwingUtilities;

import Game.Board;
import Swing.StartMenu;

/**
 * Filename: Launcher.java
 * 
 * @author Tina Hague
 * @version 1.0
 * @since 1.0
 * 
 * Last Updated:
 */
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

        //Board.clearScreen();
        System.out.println("Welcome to Tetris!");
        System.out.println("To play, it is best to extend your terminal.");
        System.out.println("The game ends when you choose to quit or when a new playable shape can not be added.");
        Board.addDelay();
        System.out.println("Are you ready to play? (yes/no)");
        String input;
        boolean lost = false;
        Board.addNewShape();

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

       // Board.clearScreen();
        Board.printBoard();

        while (!Board.isGameOver()) {
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
            switch (input) {
                case "l":
                    try{
                        Board.moveLeft();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                        Board.addDelay(1000);
                    }
                        break;
                case "r":
                    try {
                        Board.moveRight();
                    }
                    catch(Exception e) {
                        System.out.println(e.getMessage());
                        Board.addDelay(1000);
                    }
                    break;
                case "s":
                    Board.shootShapeDown();
                    break;
                case "q":
                    System.out.println("Thank you for playing!");
                    System.exit(0);
                    lost = true;
                    break;
            }
            //Board.clearScreen();
            Board.moveDown();
            Board.addNewShape();
           // Board.clearFullLines(); 
            System.out.println(Board.canMoveDown());
            Board.printBoard();
        }
        Board.flash();
        System.out.println("GAME OVER");
        // if (lost) {
        //     Board.flash();
        //     System.out.println("GAME OVER");
        // }
    }
}