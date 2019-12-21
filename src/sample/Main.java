package sample;

import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.File;

/**
 * @author Marek Baranowski
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Merry Christmas");

        AnchorPane root = new AnchorPane();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        Dimension2D dimension2D = new Dimension2D(650, 700);

        primaryStage.setScene(new Scene(root, dimension2D.getWidth(), dimension2D.getHeight()));
        primaryStage.show();

        Canvas canvasWithTree = new Canvas(dimension2D.getWidth(), dimension2D.getHeight());
        GraphicsContext gc = canvasWithTree.getGraphicsContext2D();

        Tree tree = new Tree(dimension2D);
        tree.drawTree(gc, 5);

        Claus claus = new Claus(dimension2D);
        claus.giveGift(gc, 700);

        Canvas canvasWithSnow = new Canvas(dimension2D.getWidth(), dimension2D.getHeight());
        gc = canvasWithSnow.getGraphicsContext2D();

        ListSnow listSnow = new ListSnow(dimension2D, 15);
        Snowing snowing = new Snowing(gc, dimension2D, listSnow);
        Producer producer = new Producer(listSnow);

        root.getChildren().addAll(canvasWithSnow, canvasWithTree);

        primaryStage.setOnCloseRequest(event -> {
            snowing.stop();
            producer.stop();
        });

        String musicFile = "src/sample/audio.mp3";  //Wham! Last Christmas
        AudioClip audioClip = new AudioClip(this.getClass().getResource("audio.mp3").toString());
        audioClip.setCycleCount(AudioClip.INDEFINITE);
        audioClip.play();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
