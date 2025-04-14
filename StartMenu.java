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
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(700, 1000);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        // Add TETRIS title
        title = new JLabel("TETRIS", SwingConstants.CENTER);
        title.setSize(900, 50); // Set position and size
        title.setLocation(0, 50); // Centered horizontally
        title.setFont(title.getFont().deriveFont(50.0f)); // Set font size
        title.setForeground(java.awt.Color.BLACK); // Set font color to white
        content.add(title); // Add title to the content pane

        // Add a PLAY button
        JButton playButton = new JButton("PLAY");
        playButton.setBounds(400, 200, 200, 50); // Set position and size
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
        controlsButton.setBounds(400, 270, 200, 50); // Set position and size below the PLAY button
        controlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open ControlsDisplay JFrame
                new ControlsDisplay().setVisible(true);
                dispose(); // Close the StartMenu JFrame
            }
        });

        // Add the button to the JFrame
        this.setLayout(null); // Use absolute positioning
        this.add(playButton);
        this.add(controlsButton);   
    }
}
