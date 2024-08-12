package nl.vu.cs.softwaredesign.grid;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import nl.vu.cs.softwaredesign.beat.BeatCommand;
import nl.vu.cs.softwaredesign.beat.BeatCommandHistory;
import nl.vu.cs.softwaredesign.beat.Instrument;
import nl.vu.cs.softwaredesign.player.Player;

import javax.sound.midi.*;
import javax.sound.midi.Track;
import java.util.ArrayList;
import java.util.List;

public class Grid {

    List<TrackVisual> trackVisualList = new ArrayList<>();
    Pane gridGraphic;

    BeatCommandHistory beatCommandHistory = new BeatCommandHistory();

    public Grid(){
        VBox vBox1 = new VBox();
        VBox vBox2 = new VBox();
        vBox1.setSpacing(25);
        vBox2.setSpacing(10);

        // adjust y position to align buttons with center of tracks
        vBox1.setTranslateY(8);

        for (nl.vu.cs.softwaredesign.beat.Instrument instrument : Instrument.values()) {
            TrackVisual trackVisual = new TrackVisual(instrument, beatCommandHistory);
            trackVisualList.add(trackVisual);
            vBox1.getChildren().add(trackVisual.instrument.getButtonIcon());
            vBox2.getChildren().add(trackVisual.getGraphic());
        }

        HBox hBox = new HBox(vBox1, vBox2);
        hBox.setSpacing(30);
        gridGraphic = new Pane(hBox);
    }

    public void play() {
        Sequence sequence = null;
        try {
            sequence = new Sequence(Sequence.PPQ, Player.getBpm());
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
        Track track = sequence.createTrack();

        for (TrackVisual tV : trackVisualList) {
            for (MidiEvent noteEvent : tV.getNoteEvents()) {
                track.add(noteEvent);
            }
        }

        Player.getInstance().playLoopingSequence(sequence);

    }

    public void undoLastBeat(){
        if (!beatCommandHistory.isEmpty()){
            BeatCommand beatCommand = beatCommandHistory.pop();
            beatCommand.undo();
        }
    }

    public Pane getGraphic() {
        return gridGraphic;
    }
}
