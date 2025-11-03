package com.example.herobattle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BattleField {
    private final Hero warrior;
    private final Hero mage;
    private final Pane root;

    public BattleField(Stage stage) {
        root = new Pane();

        warrior = new Hero("Warrior", Color.RED, 100, 200);
        mage = new Hero("Mage", Color.BLUE, 400, 200);

        root.getChildren().addAll(warrior.getShape(), mage.getShape());

        Scene scene = new Scene(root, 600, 400);
        stage.setTitle("Hero Battle Game");
        stage.setScene(scene);
        stage.show();

        // Смена стратегий по клавишам
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DIGIT1 -> warrior.setStrategy(new MeleeAttack());
                case DIGIT2 -> warrior.setStrategy(new RangedAttack());
                case DIGIT3 -> warrior.setStrategy(new MagicAttack());
                case SPACE -> warrior.attack(mage);
                case ENTER -> mage.attack(warrior);
            }
        });
    }

    public void startGame() {
        // начальные стратегии
        warrior.setStrategy(new MeleeAttack());
        mage.setStrategy(new MagicAttack());

        // автоатака каждые 2 сек
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> {
            if (warrior.isAlive() && mage.isAlive()) {
                warrior.attack(mage);
                mage.attack(warrior);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
