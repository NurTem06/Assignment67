package com.example.herobattle;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Hero {
    private final String name;
    private int health = 100;
    private AttackStrategy strategy;
    private final Rectangle shape;

    public Hero(String name, Color color, double x, double y) {
        this.name = name;
        this.shape = new Rectangle(x, y, 60, 60);
        this.shape.setFill(color);
    }

    public void attack(Hero target) {
        if (strategy != null && target.isAlive()) {
            strategy.attack(this, target);
        }
    }

    public void setStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
        System.out.println(name + " switched to " + strategy.getName());
    }

    public void takeDamage(int amount) {
        health -= amount;
        if (health < 0) health = 0;
        System.out.println(name + " health: " + health);
        if (health == 0) System.out.println(name + " has fallen!");
    }

    public String getName() {
        return name;
    }

    public Rectangle getShape() {
        return shape;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
