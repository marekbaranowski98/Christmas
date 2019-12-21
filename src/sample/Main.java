package sample;

import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Marek Baranowski
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Merry Christmas");

        FlowPane root = new FlowPane();
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));


        Dimension2D dimension2D = new Dimension2D(650, 700);


        primaryStage.setScene(new Scene(root, dimension2D.getWidth(), dimension2D.getHeight()));
        primaryStage.show();
        Canvas canvas = new Canvas(dimension2D.getWidth(), dimension2D.getHeight());
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Tree tree = new Tree(dimension2D);
        tree.drawTree(gc, 5);

        Claus claus = new Claus(dimension2D);
        claus.giveGift(gc, 10);

        root.getChildren().addAll(canvas);

    }

    public static void main(String[] args) {
        launch(args);
    }
}
