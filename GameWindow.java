import java.swing.JFrame;

public class GameWindow {
    private JFrame window;

    public gameWindow() {
        window = new JFrame;
        window.setTitle("Tetris");
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);
    }

    public void show() {
        window.setVissible(true;)
    }
}