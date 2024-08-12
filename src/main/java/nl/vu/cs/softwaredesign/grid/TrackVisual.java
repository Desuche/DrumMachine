package nl.vu.cs.softwaredesign.grid;


import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import nl.vu.cs.softwaredesign.beat.*;
import nl.vu.cs.softwaredesign.player.Player;

import javax.sound.midi.MidiEvent;
import java.util.ArrayList;
import java.util.List;

public class TrackVisual {

    public final Instrument instrument;
    public Pane pane;

    public List<MidiEvent> getNoteEvents() {
        return noteEvents;
    }

    public List<MidiEvent> noteEvents = new ArrayList<>();

    public Pane getGraphic() {
        return pane;
    }

    private Rectangle rectangle;

    private int beatSize = 30;

    public BeatCommandHistory beatCommandHistory;




    public TrackVisual(Instrument instrument, BeatCommandHistory beatCommandHistory){
        this.instrument = instrument;
        this.beatCommandHistory = beatCommandHistory;

        Image backgroundImage = new Image(getClass().getResource("/trackVisual.jpg").toExternalForm());
        rectangle = new Rectangle(0, 0, 500, 40);
        rectangle.setFill(new Color(0,0,0,0));
        pane = new StackPane(rectangle);
        rectangle.setOnMouseClicked(event -> trackIsClicked(event.getX()));
        pane.setBackground(new Background(new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.REPEAT,
                BackgroundRepeat.REPEAT,
                BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT)));



    }


    private void trackIsClicked(double clickX) {
        long tick = getTickFromClick(clickX);
        double translateX = clickX - rectangle.getWidth()/2;

        Beat beat = BeatFactory.createBeat(translateX, beatSize, instrument.getNoteNumber(), 9, 85, tick);
        this.executeBeatCommand(new BeatCommand(beat, this));

    }

    private void executeBeatCommand(BeatCommand beatCommand) {
        if (beatCommand.execute()){
            beatCommandHistory.push(beatCommand);
        }
    }


    public void addBeat(Beat beat){
        pane.getChildren().add(beat.getShape());
        noteEvents.add(beat.getNoteEvent());
    }

    public void removeBeat(Beat beat){
        pane.getChildren().remove(beat.getShape());
        noteEvents.remove(beat.getNoteEvent());
    }

    private long getTickFromClick(double clickLocation) {
        return (long) (clickLocation*2);
    }
}
