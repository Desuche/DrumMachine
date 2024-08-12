package nl.vu.cs.softwaredesign.beat;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import nl.vu.cs.softwaredesign.grid.TrackVisual;
import nl.vu.cs.softwaredesign.player.Player;

import javax.sound.midi.MidiEvent;
import java.util.List;
import java.util.Random;

public class BeatFactory {
    private static final Random random = new Random();

    private BeatFactory(){
    }

    public static Beat createBeat(double translateX, double size, int noteNumber, int channel, int velocity, long tick) {
        MidiEvent noteEvent = Player.createNoteOnEvent(noteNumber, channel, velocity, tick);
        return new Beat(noteEvent, randomShape(size), randomColor(), translateX);

    }

    private static Shape randomShape(double size) {
        int shapeIndex = random.nextInt(4);
        if (shapeIndex == 0) {
            return new Circle(size / 2);
        } else if (shapeIndex == 1) {
            return new Rectangle(size, size);
        } else if (shapeIndex == 2) {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(
                    size / 2, 0.0,
                    size * 0.75, size * 0.35,
                    size, size * 0.35,
                    size * 0.8, size * 0.6,
                    size * 0.9, size,
                    size / 2, size * 0.75,
                    size * 0.1, size,
                    size * 0.2, size * 0.6,
                    0.0, size * 0.35,
                    size * 0.25, size * 0.35
            );
            return polygon;
        } else {
            Polygon polygon = new Polygon();
            polygon.getPoints().addAll(
                    0.0, 0.0,
                    size, 0.0,
                    size / 2, size
            );
            return polygon;
        }
    }

    private static Color randomColor() {
        //favour darker colours for white background application
        double red =  random.nextInt(6)  * 0.1;
        double green = random.nextInt(6)  * 0.1;
        double blue =  random.nextInt(6)  * 0.1;
        return Color.color(red, green, blue);
    }

}



