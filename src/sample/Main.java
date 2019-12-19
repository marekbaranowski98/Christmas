package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Merry Christmas");

        FlowPane root = new FlowPane();

        primaryStage.setScene(new Scene(root, 350, 500));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
