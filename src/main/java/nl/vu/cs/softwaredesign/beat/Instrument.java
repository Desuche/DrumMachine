package nl.vu.cs.softwaredesign.beat;

import javafx.animation.ScaleTransition;
import javafx.scene.input.KeyCode;
import javafx.scene.control.Button;
import javafx.util.Duration;
import nl.vu.cs.softwaredesign.player.Player;

import java.util.HashMap;
import java.util.Map;

public enum Instrument {

    BASS_DRUM("Bass Drum", 35, KeyCode.A),
    SNARE_DRUM("Snare Drum", 38, KeyCode.Q),
    CLOSED_HIHAT("Closed Hi-Hat", 42, KeyCode.S),
    OPEN_HIHAT("Open Hi-Hat", 46, KeyCode.W),
    LOW_TOM("Low Tom", 41, KeyCode.Z),
    MID_TOM("Mid Tom", 47, KeyCode.X),
    HIGH_TOM("High Tom", 50, KeyCode.C),
    CRASH_CYMBAL("Crash Cymbal", 49, KeyCode.V),
    RIDE_CYMBAL("Ride Cymbal", 51, KeyCode.B),
    CLAP("Clap", 39, KeyCode.R);

    private final String name;
    private final int noteNumber;
    private final KeyCode keyCode;
    private final Button buttonIcon;
    private static final Map<KeyCode, Instrument> keyCodeMap = new HashMap<>();

    static {
        for (Instrument instrument : Instrument.values()) {
            keyCodeMap.put(instrument.keyCode, instrument);
        }
    }

    Instrument(String name, int noteNumber, KeyCode keyCode) {
        this.name = name;
        this.noteNumber = noteNumber;
        this.keyCode = keyCode;
        this.buttonIcon = new Button(name + " [" + keyCode.getName() + "]");
        this.buttonIcon.setPrefWidth(120);
        this.buttonIcon.setPrefHeight(25);
        this.buttonIcon.setOnAction(event -> {
            Player.getInstance().playInstrument(this);
            animateButton();
        });
    }

    public int getNoteNumber(){
        return this.noteNumber;
    }

    public Button getButtonIcon() {
        return buttonIcon;
    }

    public void animateButton() {
        double originalScale = 1.0;
        double expandedScale = 1.2;

        ScaleTransition scaleTransition = new ScaleTransition(Duration.seconds(0.2), buttonIcon);
        scaleTransition.setToX(expandedScale);
        scaleTransition.setToY(expandedScale);
        scaleTransition.setAutoReverse(true);
        scaleTransition.setOnFinished(event -> {
            buttonIcon.setScaleX(originalScale);
            buttonIcon.setScaleY(originalScale);
        });
        scaleTransition.play();
    }

    public static Instrument getByKeyCode(KeyCode keyCode) {
        Instrument instrument = keyCodeMap.get(keyCode);
        if (instrument == null) {
            throw new IllegalArgumentException("No instrument found with the key code: " + keyCode);
        }
        return instrument;
    }


}
