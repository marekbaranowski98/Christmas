package sample;

import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Merry Christmas");

        FlowPane root = new FlowPane();
        root.setAlignment(Pos.CENTER);
        root.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));


        Dimension2D dimension2D = new Dimension2D(650, 700);
        Tree tree = new Tree(dimension2D);
        primaryStage.setScene(new Scene(root, dimension2D.getWidth(), dimension2D.getHeight()));

        primaryStage.show();
        root.getChildren().addAll(tree.drawTree(5));

    }

    public static void main(String[] args) {
        launch(args);
    }
}
