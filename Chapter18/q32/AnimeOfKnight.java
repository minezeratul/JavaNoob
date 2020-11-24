package Chapter18.q32;

import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.util.ArrayList;

public class AnimeOfKnight extends Application {
    private static final int SIZE = 8;
    private int startX = 0;
    private int startY = 0;
    private ArrayList<Point2D> moveHistory = null;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        ChessBoard board = new ChessBoard();
        pane.setCenter(board);
        Button btSolve = new Button("Solve");
        pane.setBottom(btSolve);
        BorderPane.setAlignment(btSolve, Pos.CENTER);

        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("Knight");
        primaryStage.setScene(scene);
        primaryStage.show();

        board.paint();

        btSolve.setOnAction(e -> {
            boolean[][] moves = new boolean[SIZE][SIZE];
            moves[startX][startY] = true;
            resetMoveHistory();
            addMoveHistory(startX, startY);
            solvePuzzle(moves, 1, startX, startY);
            board.paint();
        });

        scene.widthProperty().addListener(ov -> board.paint());
        scene.heightProperty().addListener(ov -> board.paint());
    }
    private boolean solvePuzzle(boolean[][] moves, int numMoves, int x, int y) {
        int nextX = 0;
        int nextY = 0;
        int bestMoveX = 0;
        int bestMoveY = 0;
        int bestMoveX2 = 0;
        int bestMoveY2 = 0;
        int minMoveCount = SIZE;
        int moveCount = 0;

        for (int i = 2; i >= -2; i += -4) {
            for (int j = 1; j >= -1; j += -2) {
                nextX = x + i;
                nextY = y + j;
                if (nextX >= 0 && nextX <= SIZE - 1 && nextY >= 0 && nextY <= SIZE - 1
                        && !moves[nextX][nextY]) {
                    moveCount = lookAheadCount(moves, nextX, nextY);
                    if (moveCount <= minMoveCount) {
                        minMoveCount = moveCount;
                        bestMoveX2 = bestMoveX;
                        bestMoveY2 = bestMoveY;
                        bestMoveX = nextX;
                        bestMoveY = nextY;
                    }
                }

                nextX = x + j;
                nextY = y + i;
                if (nextX >= 0 && nextX <= SIZE - 1 && nextY >= 0 && nextY <= SIZE - 1
                        && !moves[nextX][nextY]) {
                    moveCount = lookAheadCount(moves, nextX, nextY);
                    if (moveCount <= minMoveCount) {
                        minMoveCount = moveCount;
                        bestMoveX2 = bestMoveX;
                        bestMoveY2 = bestMoveY;
                        bestMoveX = nextX;
                        bestMoveY = nextY;
                    }
                }
            }
        }
        moves[bestMoveX][bestMoveY] = true;
        addMoveHistory(bestMoveX, bestMoveY);
        numMoves++;
        if (numMoves == (SIZE * SIZE))
            return true;
        if (moveCount > 0 && solvePuzzle(moves, numMoves, bestMoveX, bestMoveY)) {
            return true;
        }
        moves[bestMoveX][bestMoveY] = false;
        moves[bestMoveX2][bestMoveY2] = true;
        removeLastMoveHistory();
        addMoveHistory(bestMoveX2, bestMoveY2);
        if (moveCount > 1 && solvePuzzle(moves, numMoves, bestMoveX2, bestMoveY2)) {
            return true;
        }
        moves[bestMoveX2][bestMoveY2] = false;
        removeLastMoveHistory();
        numMoves--;
        return false;
    }

    private int lookAheadCount(boolean[][] moves, int x, int y) {
        int maxCount = 0;
        for (int i = -2; i <= 2; i += 4) {
            for (int j = -1; j <= 1; j += 2) {
                int nextX = x + i;
                int nextY = y + j;
                if (nextX >= 0 && nextX <= SIZE - 1 && nextY >= 0 && nextY <= SIZE - 1
                        && !moves[nextX][nextY]) {
                    maxCount++;
                }

                nextX = x + j;
                nextY = y + i;
                if (nextX >= 0 && nextX <= SIZE - 1 && nextY >= 0 && nextY <= SIZE - 1
                        && !moves[nextX][nextY]) {
                    maxCount++;
                }
            }
        }
        return maxCount;
    }

    public void resetMoveHistory() {
        moveHistory = new ArrayList(63);
    }

    public void addMoveHistory(int x, int y) {
        moveHistory.add(new Point2D(x, y));
    }

    public void removeLastMoveHistory() {
        moveHistory.remove(moveHistory.size() - 1);
    }

    private class ChessBoard extends Pane {
        ImageView knightImageView = new ImageView("image/knight.jpg");

        ChessBoard() {
            this.setOnMouseClicked(e -> {
                startX = (int)(e.getX() / (getWidth() / SIZE));
                startY = (int)(e.getY() / (getHeight() / SIZE));
                resetMoveHistory();
                paint();
            });
        }

        protected void paint() {
            this.getChildren().clear();

            this.getChildren().add(knightImageView);
            knightImageView.setX(startX * getWidth() / SIZE);
            knightImageView.setY(startY * getHeight() / SIZE);
            knightImageView.setFitWidth(getWidth() / SIZE);
            knightImageView.setFitHeight(getHeight() / SIZE);
            for (int i = 1; i <= SIZE; i++) {
                this.getChildren().add(
                        new Line(0, i * getHeight() / SIZE, getWidth(), i * getHeight() / SIZE));
                this.getChildren().add(
                        new Line(i * getWidth() / SIZE, 0, i * getWidth() / SIZE, getHeight()));
            }

            if (moveHistory != null) {
                for (int i = 1; i < moveHistory.size(); i++) {
                    Point2D p1 = moveHistory.get(i - 1);
                    Point2D p2 = moveHistory.get(i);
                    this.getChildren().add(
                            new Line(p1.getX() * (getWidth() / SIZE) + getWidth() / SIZE / 2,
                                    p1.getY() * (getHeight() / SIZE) + (getHeight() / SIZE / 2),
                                    p2.getX() * (getWidth() / SIZE) + getWidth() / SIZE / 2,
                                    p2.getY() * (getHeight() / SIZE) + getHeight() / SIZE / 2));
                }
            }
        }
    }
}
