package Chapter20.q2;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;

public class Test2 extends Application {
    private LinkedList<Integer> list = new LinkedList<Integer>();
    private TextField tfNumber = new TextField();
    private TextArea taNumbers = new TextArea();
    private Button btSort = new Button("Sort");
    private Button btShuffle = new Button("Shuffle");
    private Button btReverse = new Button("Reverse");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(10);
        hBox.getChildren().addAll(new Label("Enter a number: "), tfNumber);
        hBox.setAlignment(Pos.CENTER);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(hBox);
        borderPane.setCenter(new ScrollPane(taNumbers));

        HBox hBoxForButtons = new HBox(10);
        hBoxForButtons.getChildren().addAll(btSort, btShuffle, btReverse);
        hBoxForButtons.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBoxForButtons);

        Scene scene = new Scene(borderPane, 400, 210);
        primaryStage.setTitle("Test2");
        primaryStage.setScene(scene);
        primaryStage.show();

        tfNumber.setOnAction(e -> {
            if (!list.contains(new Integer(tfNumber.getText()))) {
                taNumbers.appendText(tfNumber.getText() + " ");
                list.add(new Integer(tfNumber.getText()));
            }
        });

        btSort.setOnAction(e -> {
            Collections.sort(list);
            display();
        });

        btShuffle.setOnAction(e -> {
            Collections.shuffle(list);
            display();
        });

        btReverse.setOnAction(e -> {
            Collections.reverse(list);
            display();
        });
    }

    private void display() {
        taNumbers.setText(null);
        for (Integer i: list) {
            taNumbers.appendText(i + " ");
        }
    }
}
