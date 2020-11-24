package Chapter18.q37;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class ArcLenght extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HilbertCurvePane pane = new HilbertCurvePane();
        TextField tfOrder = new TextField();
        tfOrder.setOnAction(
                e -> pane.setOrder(Integer.parseInt(tfOrder.getText())));
        tfOrder.setPrefColumnCount(4);
        tfOrder.setAlignment(Pos.BOTTOM_RIGHT);

        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter an order: "), tfOrder);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hBox);

        Scene scene = new Scene(borderPane, 200, 210);
        primaryStage.setTitle("Arc");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.widthProperty().addListener(ov -> pane.paint());
        scene.heightProperty().addListener(ov -> pane.paint());
    }

    static class HilbertCurvePane extends Pane {
        private double x, y;
        private double length;
        private int order = 1;

        /** Set a new order */
        public void setOrder(int order) {
            this.order = order;
            paint();
        }

        protected void paint() {
            length = Math.min(getWidth(), getHeight());
            for (int i = 0; i < order; i++)
                length /= 2;

            x = length / 2; y = length / 2;

            this.getChildren().clear();

            upperU(order);
        }

        private void upperU(int order) {
            if (order > 0) {
                leftU(order - 1);
                lineNewPosition(0, length);
                upperU(order - 1);
                lineNewPosition(length, 0);
                upperU(order - 1);
                lineNewPosition(0, -length);
                rightU(order - 1);
            }
        }

        private void leftU(int order) {
            if (order > 0) {
                upperU(order - 1);
                lineNewPosition(length, 0);
                leftU(order - 1);
                lineNewPosition(0, length);
                leftU(order - 1);
                lineNewPosition(-length, 0);
                downU(order - 1);
            }
        }

        private void rightU(int order) {
            if (order > 0) {
                downU(order - 1);
                lineNewPosition(-length, 0);
                rightU(order - 1);
                lineNewPosition(0, -length);
                rightU(order - 1);
                lineNewPosition(length, 0);
                upperU(order - 1);
            }
        }

        private void downU(int order) {
            if (order > 0) {
                rightU(order - 1);
                lineNewPosition(0, -length);
                downU(order - 1);
                lineNewPosition(-length, 0);
                downU(order - 1);
                lineNewPosition(0, length);
                leftU(order - 1);
            }
        }

        public void lineNewPosition(double deltaX, double deltaY) {
            getChildren().add(new Line(x, y, x + deltaX, y + deltaY));
            x += deltaX;
            y += deltaY;
        }
    }
}
