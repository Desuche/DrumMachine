package nl.vu.cs.softwaredesign.player;

import javafx.beans.property.SimpleDoubleProperty;
import nl.vu.cs.softwaredesign.beat.Instrument;

import javax.sound.midi.*;

public class Player {

    private static Player instance;

    Synthesizer synthesizer;
    Sequencer sequencer;
    SequenceRecorder sequenceRecorder;

    MidiChannel channel;
    public SimpleDoubleProperty bpm = new SimpleDoubleProperty(120);
    private boolean recordingManualSequence = false;
    private boolean playingBack = false;



    private Player() {
        try {
            synthesizer = MidiSystem.getSynthesizer();
            sequencer = MidiSystem.getSequencer();
            sequenceRecorder = new SequenceRecorder();
            channel = synthesizer.getChannels()[9];


            synthesizer.open();
            sequencer.open();

        } catch (MidiUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public static Player getInstance(){
        if (instance == null){
            instance = new Player();
        }
        return instance;
    }



    public static MidiEvent createNoteOnEvent(int noteNumber, int channel, int velocity, long tick) {
        ShortMessage message = new ShortMessage();
        try {
            message.setMessage(ShortMessage.NOTE_ON, channel, noteNumber, velocity);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
        return new MidiEvent(message, tick);
    }

    public void playSequence(Sequence sequence){
        sequencer.setTickPosition(0);
        try {
            sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
        sequencer.start();
    }

    public void playLoopingSequence(Sequence sequence) {
        sequencer.setTickPosition(0);
        try {
            sequencer.setLoopCount(Sequencer.LOOP_CONTINUOUSLY);
            sequencer.setSequence(sequence);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
        sequencer.start();
    }

    public void playLastRecordedManualSequence(){
        Sequence lastRecordedSequence = sequenceRecorder.getLastRecordedSequence();
        playSequence(lastRecordedSequence);
    }

    public void playInstrument(Instrument instrument){
        this.channel.noteOn(instrument.getNoteNumber(), 85);
        if (recordingManualSequence){
            sequenceRecorder.sequenceNote(instrument.getNoteNumber(), 85);
        }
    }


    public static int getBpm() {
        return (int) getInstance().bpm.doubleValue();
    }


    public void setRecordingManualSequence(boolean recordingManualSequence) {
        this.recordingManualSequence = recordingManualSequence;
    }


    public void setPlayingBack(boolean playingBack) {
        this.playingBack = playingBack;
    }

    public void stopSequencer() {
        sequencer.stop();
    }

    public void startRecording() {
        sequenceRecorder.startRecording();
    }

}
