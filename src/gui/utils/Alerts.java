package gui.utils;

import javafx.animation.Timeline;
import javafx.scene.control.Alert;

public class Alerts {
    public static void gameOver(Timeline timeline) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("GAME OVER");
        alert.setHeaderText(null);
        alert.setContentText("Você Perdeu :/");
        alert.setOnHidden(evt -> timeline.play());
        alert.show();
    }
}
