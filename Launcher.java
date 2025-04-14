

import javax.swing.SwingUtilities;

import Swing.StartMenu;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StartMenu menu = new StartMenu();
                //ControlsDisplay controls = new ControlsDisplay();
                //GameDisplay game = new GameDisplay();
                menu.setVisible(true);
            }
        });
    }
}