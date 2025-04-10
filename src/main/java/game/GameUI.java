package game;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class GameUI {
    private Player player;
    private Enemy enemy;
    private TextArea log;
    private ProgressBar playerHpBar, enemyHpBar;

    public void start(Stage stage) {
        player = new Player("Arthas");
        enemy = new Enemy("Dragón Oscuro", 100, 20);

        // Elementos
        Label title = new Label("🏰 El Guerrero y la Princesa");
        title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        playerHpBar = new ProgressBar(1);
        enemyHpBar = new ProgressBar(1);
        log = new TextArea("¡Comienza la batalla!\n");
        log.setEditable(false);
        log.setPrefHeight(200);

        HBox hpBars = new HBox(10,
                new VBox(new Label("💪 Guerrero"), playerHpBar),
                new VBox(new Label("🐉 Enemigo"), enemyHpBar)
        );

        Button attackBtn = new Button("Atacar");
        Button healBtn = new Button("Curarse");
        Button fleeBtn = new Button("Huir");

        attackBtn.setOnAction(e -> {
            player.attack(enemy);
            log.appendText("Atacas al enemigo.\n");
            updateBars();
            if (enemy.isAlive()) enemyTurn();
            else endGame(stage, true);
        });

        healBtn.setOnAction(e -> {
            player.heal();
            log.appendText("Te curaste.\n");
            enemyTurn();
            updateBars();
        });

        fleeBtn.setOnAction(e -> {
            log.appendText("Escapas de la batalla. 🏃‍♂️\n");
            endGame(stage, false);
        });

        HBox buttons = new HBox(10, attackBtn, healBtn, fleeBtn);
        buttons.setAlignment(Pos.CENTER);

        VBox layout = new VBox(15, title, hpBars, buttons, log);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-padding: 20px;");

        Scene scene = new Scene(layout, 500, 400);
        stage.setScene(scene);
        stage.setTitle("Juego de Rol");
        stage.show();
    }

    private void enemyTurn() {
        if (player.isAlive()) {
            enemy.attack(player);
            log.appendText("El enemigo ataca.\n");
            updateBars();
            if (!player.isAlive()) log.appendText("Has muerto...\n");
        }
    }

    private void updateBars() {
        playerHpBar.setProgress(Math.max(0, (double) player.hp / player.maxHp));
        enemyHpBar.setProgress(Math.max(0, (double) enemy.hp / 100));
    }

    private void endGame(Stage stage, boolean win) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Resultado");
        alert.setHeaderText(null);
        alert.setContentText(win ? "¡Has rescatado a la princesa! 👑" : "Perdiste o escapaste... 💀");
        alert.setOnCloseRequest(e -> stage.close());
        alert.show();
    }
}
