package Chapter20.q5;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ball extends Circle {
    double dx = 1, dy = 1;

    Ball(double x, double y, double radius, Color color) {
        super(x, y, radius);
        setFill(color); // Set ball color
    }

    public boolean isCollideWith(Ball b) {
        double distanceBetweenTheTwoBalls =
                (Math.sqrt(Math.pow(getCenterX() - b.getCenterX(), 2) +
                        Math.pow(getCenterY() - b.getCenterY(), 2)));
        return distanceBetweenTheTwoBalls <= b.getRadius() + getRadius();
    }
}
