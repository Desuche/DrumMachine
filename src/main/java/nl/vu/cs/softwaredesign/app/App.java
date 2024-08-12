package nl.vu.cs.softwaredesign.app;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import nl.vu.cs.softwaredesign.grid.Grid;

public class App extends Application {
    Grid grid = new Grid();
    Controls controls = new Controls(grid);


    @Override
    public void start(Stage primaryStage) {


        VBox root = new VBox(controls.getGraphic(), grid.getGraphic());
        root.setSpacing(40);
        root.setPadding(new Insets(20));



        Scene scene = new Scene(root, 750, 700);
        scene.setOnKeyPressed(event -> {
            if (event.isControlDown() && event.getCode() == KeyCode.Z) {
                this.grid.undoLastBeat();
            } else {
                Controls.playKey(event.getCode());
            }
        });

        primaryStage.setTitle("Drum Machine");
        primaryStage.setScene(scene);
        primaryStage.setOnCloseRequest(event -> System.exit(0));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}