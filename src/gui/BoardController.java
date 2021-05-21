package gui;

import gui.utils.Alerts;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import model.entities.Board;

import java.io.InputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class BoardController implements Initializable {
    private final Circle SNAKE_HEAD = new Circle(50, 50, 15, Color.web("8E09E0"));
    private final Board board = new Board();
    private Timeline timeline;
    private final InputStream input = this.getClass().getResourceAsStream("/gui/utils/purpleapple.png");
    private final Image image = new Image(input, 40, 40, false, true);
    private final ImageView imageView = new ImageView(image);

    @FXML
    private Label points;

    @FXML
    private GridPane gridPane;

    @FXML
    public void onKeyPressedHandle(KeyEvent e) {

        if (e.getCode() == KeyCode.W) {
            board.setDirection('W');
        } else if (e.getCode() == KeyCode.A) {
            board.setDirection('A');
        } else if (e.getCode() == KeyCode.S) {
            board.setDirection('S');
        } else if (e.getCode() == KeyCode.D) {
            board.setDirection('D');
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gridPane.setFocusTraversable(true);
        board.generateApple();
        timeline = new Timeline(
                new KeyFrame(Duration.seconds(0.1), e -> {
                    //clean the grid
                    gridPane.getChildren().clear();

                    //update points
                    points.setText("Points: " + (board.getSnake().getSnakeBody().size() - 1));

                    //check collision before continuing
                    if (board.checkCollision()) {
                        timeline.stop();
                        Alerts.gameOver();
                    }
                    //update and draw snake
                    board.move();
                    gridPane.add(SNAKE_HEAD, board.getSnake().getSnakeBody().get(0).getxPos(), board.getSnake().getSnakeBody().get(0).getyPos());

                    //Draw snake tail
                    for (int i = 1; i < board.getSnake().getSnakeBody().size(); i++) {
                        gridPane.add(new Circle(50, 50, 13, Color.web("4205B6")), board.getSnake().getSnakeBody().get(i).getxPos(), board.getSnake().getSnakeBody().get(i).getyPos());
                    }
                    gridPane.add(imageView, board.getFruit().getFruitPos().getxPos(), board.getFruit().getFruitPos().getyPos());
                })
        );

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();


    }

}