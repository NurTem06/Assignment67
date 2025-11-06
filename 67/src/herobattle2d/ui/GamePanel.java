package herobattle2d.ui;

import herobattle2d.heroes.*;
import herobattle2d.strategies.*;
import herobattle2d.observers.*;
import herobattle2d.game.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, Runnable {
    private Hero player;
    private Hero enemy;
    private Thread gameThread;
    private boolean running = true;

    public GamePanel() {
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.BLACK);
        setFocusable(true);
        addKeyListener(this);

        player = HeroFactory.createHero("warrior", "Player", 100, 400);
        enemy = HeroFactory.createHero("mage", "Enemy", 600, 400);

        player.setStrategy(new MeleeAttack());
        enemy.setStrategy(new MagicAttack());

        BattleAnnouncer announcer = new BattleAnnouncer();
        player.registerObserver(announcer);
        enemy.registerObserver(announcer);

        GameLogger.getInstance().log("Game started!");
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (running) {
            checkCollision();
            repaint();
            try {
                Thread.sleep(33); // ~30 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void checkCollision() {
        if (player.getBounds().intersects(enemy.getBounds())) {
            GameLogger.getInstance().log("Player is near the enemy!");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        player.draw(g);
        enemy.draw(g);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT)  player.move(-10, 0);
        if (key == KeyEvent.VK_RIGHT) player.move(10, 0);
        if (key == KeyEvent.VK_UP)    player.move(0, -10);
        if (key == KeyEvent.VK_DOWN)  player.move(0, 10);

        if (key == KeyEvent.VK_A && player.isAlive() && enemy.isAlive()) {
            player.attack(enemy);
            if (enemy.isAlive()) {
                enemy.attack(player); // enemy retaliates
            }
        }

        repaint();
    }

    @Override public void keyReleased(KeyEvent e) {}
    @Override public void keyTyped(KeyEvent e) {}
}
