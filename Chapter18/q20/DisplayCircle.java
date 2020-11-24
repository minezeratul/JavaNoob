package Chapter18.q20;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class DisplayCircle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new CirclePane(), 200, 200);
        primaryStage.setTitle("DisplayCircle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static class CirclePane extends Pane {
        private double radius = 80;

        public CirclePane() {
            displayCircles();
        }

        private void displayCircles() {
            if (radius >= 5) {
                Circle c = new Circle(100, 100, radius);
                c.setFill(Color.WHITE);
                c.setStroke(Color.BLACK);
                getChildren().add(c);
                radius -= 5;
                displayCircles();
            }
        }
    }
}
