package Chapter21.q11;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test11 extends Application {
    private Map<String, Integer>[] mapForBoy = new HashMap[10];
    private Map<String, Integer>[] mapForGirl = new HashMap[10];

    private Button btFindRanking = new Button("Find Ranking");
    private ComboBox<Integer> cboYear = new ComboBox<>();
    private ComboBox<String> cboGender = new ComboBox<>();
    private TextField tfName = new TextField();
    private Label lblResult = new Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
        gridPane.add(new Label("Select a year:"), 0, 0);
        gridPane.add(new Label("Boy or girl?"), 0, 1);
        gridPane.add(new Label("Enter a name:"), 0, 2);
        gridPane.add(cboYear, 1, 0);
        gridPane.add(cboGender, 1, 1);
        gridPane.add(tfName, 1, 2);
        gridPane.add(btFindRanking, 1, 3);
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(gridPane);
        borderPane.setBottom(lblResult);
        BorderPane.setAlignment(lblResult, Pos.CENTER);

        Scene scene = new Scene(borderPane, 370, 160);
        primaryStage.setTitle("BabyName Ranking");
        primaryStage.setScene(scene);
        primaryStage.show();

        for (int year = 2001; year <= 2010; year++) {
            cboYear.getItems().add(year);
        }
        cboYear.setValue(2001);

        cboGender.getItems().addAll("Male", "Female");
        cboGender.setValue("Male");

        btFindRanking.setOnAction(e -> findRanking());

        readNames();
    }

    public void findRanking() {
        int year = cboYear.getSelectionModel().getSelectedItem();
        String gender = cboGender.getSelectionModel().getSelectedItem();
        String name = tfName.getText().trim();

        if (gender.equals("Male")) {
            if (mapForBoy[year - 2001].containsKey(name))
                lblResult.setText("Boy name " + name + " is ranked #" +
                        mapForBoy[year - 2001].get(name) + " in year " + year);
            else
                lblResult.setText("Boy name " + name
                        + " is not ranked in year " + year);
        }
        else {
            if (mapForGirl[year - 2001].containsKey(name))
                lblResult.setText("Girl name " + name + " is ranked #" +
                        mapForGirl[year - 2001].get(name) + " in year " + year);
            else
                lblResult.setText("Girl name " + name
                        + " is not ranked in year " + year);
        }
    }

    private void readNames() {
        try {
            for (int i = 0; i <= 9; i++) {
                String filename = "D:\\IDEA\\src\\text\\babynamesranking" + (2001 + i) + ".txt" ;
                File file = new File(filename);
                Scanner input = new Scanner(file);

                mapForBoy[i] = new HashMap<>();
                mapForGirl[i] = new HashMap<>();
                while (input.hasNext()) {
                    int ranking = input.nextInt();
                    String boyname = input.next();
                    input.nextInt(); // Skip the number of boy's name
                    String girlname = input.next();
                    input.nextInt(); // Skip the number of girl's name

                    mapForBoy[i].put(boyname, ranking);
                    mapForGirl[i].put(girlname, ranking);
                }
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
