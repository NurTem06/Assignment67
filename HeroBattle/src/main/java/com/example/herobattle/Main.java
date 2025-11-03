package com.example.herobattle;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
        BattleField battleField = new BattleField(stage);
        battleField.startGame();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
