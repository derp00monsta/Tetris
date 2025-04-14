package Swing;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlDisplay extends JFrame {
    
    JLabel title;
    Container content = getContentPane();

    public ControlDisplay() {
        initialize();
    }

    private void initialize() {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(700, 800);
        content.setBackground(Color.BLACK);
        this.setTitle("Tetris");
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // add CONTROLS title
        title = new JLabel("CONTROLS", SwingConstants.CENTER);;
        title.setBounds(150, 250, 400, 50); // Set size
        title.setFont(title.getFont().deriveFont(50.0f)); // Set font size
        title.setForeground(Color.GREEN);

        // add controls text
        JTextArea controls = new JTextArea();
        controls.setText( "Start: SPACE\n" +
                "Move Left: left arrow key\n" +
                "Move Right: right arrow key\n" +
                "Drop: down arrow key\n" +
                "Quit: ESC\n");
        controls.setBounds(200, 340, 600, 400); // Set size and position
        controls.setFont(new Font("Consolas", Font.PLAIN, 20)); // Set font size
        controls.setForeground(Color.GREEN); 
        controls.setBackground(getForeground());

        // Add a BACK button
        JButton backButton = new JButton("BACK");
        backButton.setBounds(10, 10, 100, 30); // Set position and size
        backButton.setBackground(new Color(2, 41, 0)); 
        backButton.setForeground(Color.GREEN);
        backButton.setFocusPainted(false);
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
        this.add(title);
        this.add(controls);
    }
}
