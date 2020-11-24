package Chapter20.q5;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

import java.util.List;

public class MultipleBallPane extends Pane {
    private Timeline animation;

    public MultipleBallPane() {

        animation = new Timeline(
                new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play(); // Start animation

        this.setOnMousePressed(e -> {
            List<Node> ballList = getChildren();
            for (int i = 0; i < ballList.size(); i++) {
                if (ballList.get(i).contains(e.getX(), e.getY())) {
                    ballList.remove(i);
                    break;
                }
            }
        });
    }

    public void add() {
        Color color = new Color(Math.random(),
                Math.random(), Math.random(), 0.5);
        getChildren().add(new Ball(30, 30, 5, color));
    }

    public void subtract() {
        if (getChildren().size() > 0) {
            getChildren().remove(getChildren().size() - 1);
        }
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(
                animation.getRate() > 0 ? animation.getRate() - 0.1 : 0);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }

    protected void moveBall() {
        for (Node node: this.getChildren()) {
            Ball ball = (Ball)node;
            // Check boundaries
            if (ball.getCenterX() < ball.getRadius() ||
                    ball.getCenterX() > getWidth() - ball.getRadius()) {
                ball.dx *= -1; // Change ball move direction
            }
            if (ball.getCenterY() < ball.getRadius() ||
                    ball.getCenterY() > getHeight() - ball.getRadius()) {
                ball.dy *= -1; // Change ball move direction
            }

            // Adjust ball position
            ball.setCenterX(ball.dx + ball.getCenterX());
            ball.setCenterY(ball.dy + ball.getCenterY());
        }

        // Detect collision
        List<Node> ballList = this.getChildren();
        for (int i = 0; i < ballList.size(); i++) {
            for (int j = i + 1; j < ballList.size(); j++) {
                if (((Ball)(ballList.get(i))).isCollideWith(
                        (Ball)(ballList.get(j)))) {
                    // Change the radius for i
                    ((Ball)(ballList.get(i))).setRadius(
                            ((Ball)ballList.get(i)).getRadius() +
                                    ((Ball)ballList.get(j)).getRadius());

                    // Remove j
                    ballList.remove(ballList.get(j));
                }
            }
        }
    }
}
