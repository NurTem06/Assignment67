package herobattle2d.heroes;

import herobattle2d.strategies.AttackStrategy;
import herobattle2d.observers.Observer;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    protected String name;
    protected int health;
    protected int x, y;
    protected Color color;
    protected AttackStrategy strategy;
    protected List<Observer> observers = new ArrayList<>();

    public Hero(String name, int x, int y, Color color) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = color;
        this.health = 100;
    }

    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
        notifyObservers(name + " switched to " + strategy.getClass().getSimpleName());
    }

    public void attack(Hero target) {
        if (strategy != null && target.isAlive()) {
            strategy.attack(name, target.name);
            target.takeDamage(10);
            notifyObservers(name + " attacked " + target.name);
        }
    }

    public void takeDamage(int dmg) {
        health -= dmg;
        if (health <= 0) {
            health = 0;
            notifyObservers(name + " has been defeated!");
        } else {
            notifyObservers(name + " took " + dmg + " damage (HP: " + health + ")");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    protected void notifyObservers(String event) {
        for (Observer o : observers) o.update(event);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, 50, 50);
        g.setColor(Color.WHITE);
        g.drawString(name + " (" + health + ")", x, y - 10);
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 50, 50);
    }
}
