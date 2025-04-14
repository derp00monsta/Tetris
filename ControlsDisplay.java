import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlsDisplay extends JFrame {

    public ControlsDisplay() {
        initialize();
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
}
