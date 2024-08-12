package nl.vu.cs.softwaredesign.app;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.Text;
import nl.vu.cs.softwaredesign.grid.Grid;
import nl.vu.cs.softwaredesign.beat.Instrument;
import nl.vu.cs.softwaredesign.player.Player;


public class Controls {
    private final Pane controlsGraphics;

    public Controls(Grid grid){
        HBox buttonHolder = new HBox();

        Text text = new Text("READY");
        text.setFont(Font.font("Arial", FontPosture.ITALIC, 12));
        text.setFill(Color.RED);

        Button playButton = new Button("Play");
        Button stopButton = new Button("Stop");
        Button recordButton = new Button("Start Recording");
        Button stopRecordButton = new Button("Stop Recording");
        Button playRecButton = new Button("Play Recording");


        Slider bpmSlider = new Slider();
        bpmSlider.setMin(60);
        bpmSlider.setMax(360);
        bpmSlider.valueProperty().bindBidirectional(Player.getInstance().bpm);
        bpmSlider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (text.getText().equals("PLAYING")){
                grid.play();
            }
        });

        Label bpmLabel = new Label();
        bpmLabel.textProperty().bind(bpmSlider.valueProperty().asString("BPM: %.0f"));
        VBox bpmControl = new VBox(5);
        bpmControl.getChildren().addAll(bpmSlider, bpmLabel);
        bpmControl.setPadding(new Insets(5, 20, 0, 20));

        buttonHolder.getChildren().addAll(playButton, stopButton, recordButton, stopRecordButton, playRecButton, bpmControl);




        playButton.setOnAction(event -> {
            Controls.playGrid(grid);
            text.setText("PLAYING");
        });
        stopButton.setOnAction(event -> {
            Controls.stop();
            text.setText("STOPPED PLAYING");
        });
        playRecButton.setOnAction(event -> {
            Controls.playManualRecording();
            text.setText("PLAYING RECORDING");
        });
        recordButton.setOnAction(event -> {
            Controls.startRecording();
            text.setText("RECORDING");
        });
        stopRecordButton.setOnAction(event -> {
            Controls.stopRecording();
            text.setText("STOPPED RECORDING");
        });

        VBox vBox = new VBox(buttonHolder, text);
        vBox.setSpacing(20);
        controlsGraphics = new Pane(vBox);
    }


    public Pane getGraphic() {
        return controlsGraphics;
    }

    public static void playGrid(Grid grid){
        grid.play();
    }

    public static void stop() {
        Player.getInstance().stopSequencer();
    }


    public static void playManualRecording(){
        Player player = Player.getInstance();
        player.setRecordingManualSequence(false);
        player.setPlayingBack(true);
        player.playLastRecordedManualSequence();
    }

    public static void startRecording(){
        Player player = Player.getInstance();
        player.setRecordingManualSequence(true);
        player.setPlayingBack(false);
        player.startRecording();
    }

    public static void stopRecording(){
        Player player = Player.getInstance();
        player.setRecordingManualSequence(false);

    }

    public static void playKey(KeyCode code){
        try {
            Instrument instrument = Instrument.getByKeyCode(code);
            Player.getInstance().playInstrument(instrument);
            instrument.animateButton();
        } catch (IllegalArgumentException e){

        }

    }
}
