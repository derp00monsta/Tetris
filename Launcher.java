

import java.util.Scanner;

import javax.swing.SwingUtilities;

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
        Scanner scanner = new Scanner(System.in);
        welcomePrint();
        String input;
        boolean startGame = false;

        
        while(true) {
            while(true) {
                try {
                    input = scanner.nextLine();
                    break;
                }
                catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }
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

    
        
    }

    public static void welcomePrint() {
        System.out.println("Welcome to Tetris!");
        System.out.println();
        addDelay();
        System.out.println("Press ENTER to start the game.");
        addDelay();
        System.out.println("Press ESC to quit the game.");
        addDelay();
        System.out.println("Press SPACE to pause the game.");
        addDelay();
        System.out.println("Press the LEFT arrow key to move left.");   
        addDelay();
        System.out.println("Press the RIGHT arrow key to move right.");
        addDelay();
        System.out.println("Press the DOWN arrow key to drop the block.");
        addDelay();
        System.out.println("Press the SPACE key to shoot the block down.");
        addDelay();
        System.out.println();
        System.out.println();
        System.out.println();

        System.out.println("Are you ready to play? (yes/no)");
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