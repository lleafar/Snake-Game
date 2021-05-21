package gui.utils;

import javafx.scene.control.Alert;

public class Alerts {
    public static void gameOver() {
        Alert alert = new Alert(Alert.AlertType.WARNING);

        alert.setTitle("GAME OVER");
        alert.setHeaderText(null);
        alert.setContentText("Você Perdeu :/");

        alert.setOnHidden(evt -> System.exit(0) );
        alert.show();
    }


}
