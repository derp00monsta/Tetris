package Swing;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameDisplay extends JFrame {

    public GameDisplay() {
        initialize();
        runGame(); // Call the runGame method to start the game
    }

    private void initialize() {
        this.setTitle("Tetris (Menu)");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(900, 500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Add a BACK button
        JButton backButton = new JButton("BACK");
        backButton.setBounds(10, 10, 100, 30); // Set position and size
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open StartMenu JFrame
                new StartMenu().setVisible(true);
                dispose(); // Close the GameDisplay JFrame
            }
        });

        // Add the button to the JFrame
        this.setLayout(null); // Use absolute positioning
        this.add(backButton);
    }

    // create a loop that runs the game
    // every 2 seconds the shape will fall down by one block ()
    //  every time the user provides input the shape will move 
    public void runGame() {
        // Create a new Board object and start the game
        // Board board = new Board();
    }
}
