package Swing;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StartMenu extends JFrame {
    
    JLabel title;
    Container content = getContentPane();
    
    /**
     * Creates the start menu JFrame
     */
    public StartMenu() {
        initialize();
    }

    /**
     * Provides specifications to the JFrame object 
     */
    private void initialize() {
        this.setTitle("Tetris (Menu)");
        content.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(700, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Add TETRIS title
        title = new JLabel("TETRIS", SwingConstants.CENTER);
        title.setBounds(250, 200, 200, 50); // Set size
        title.setFont(title.getFont().deriveFont(50.0f)); // Set font size
        title.setForeground(Color.GREEN); // Set font color to white
        this.add(title); // Add title to the content pane

        // Add a PLAY button
        JButton playButton = new JButton("PLAY");
        playButton.setBounds(250, 350, 200, 50); // Set position and size
        playButton.setBackground(new Color(2, 41, 0)); // Set button color to green
        playButton.setForeground(Color.GREEN); // Set button text color to white
        playButton.setFocusPainted(false);
        playButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open GameDisplay JFrame
                new GameDisplay().setVisible(true);
                dispose(); // Close the StartMenu JFrame
            }
        });

        // Add a CONTROLS button
        JButton controlsButton = new JButton("CONTROLS");
        controlsButton.setBounds(250, 420, 200, 50); // Set position and size below the PLAY button
        controlsButton.setBackground(new Color(2, 41, 0)); // Set button color to green
        controlsButton.setForeground(Color.GREEN); // Set button text color to white
        controlsButton.setFocusPainted(false);
        controlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open ControlsDisplay JFrame
                new ControlDisplay().setVisible(true);
                dispose(); // Close the StartMenu JFrame
            }
        });

        // Add the button to the JFrame
        this.setLayout(null); // Use absolute positioning
        this.add(playButton);
        this.add(controlsButton);   
    }
}
