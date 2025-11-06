package herobattle2d.game;

import herobattle2d.ui.GamePanel;
import javax.swing.*;

public class Game {
    public void start() {
        JFrame frame = new JFrame("Hero Battle 2D");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new GamePanel());
        frame.pack();
        frame.setVisible(true);
    }
}
