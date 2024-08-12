package nl.vu.cs.softwaredesign.beat;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import nl.vu.cs.softwaredesign.grid.TrackVisual;

import javax.sound.midi.MidiEvent;
import java.util.List;

public class Beat {
    protected MidiEvent noteEvent;
    protected Shape shape;

    public Beat(MidiEvent noteEvent, Shape shape, Color color, double translateX){
        this.noteEvent = noteEvent;
        this.shape = shape;
        this.shape.setFill(color);
        this.shape.setTranslateX(translateX);

    }

    public MidiEvent getNoteEvent() {
        return noteEvent;
    }

    public Shape getShape() {
        return shape;
    }
}
