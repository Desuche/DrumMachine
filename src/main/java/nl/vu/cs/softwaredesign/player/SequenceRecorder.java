package nl.vu.cs.softwaredesign.player;

import nl.vu.cs.softwaredesign.player.Player;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Track;

public class SequenceRecorder {

    private long tick;


    private Sequence lastRecordedSequence;
    private Track track;
    private long prevTime;
    private long currentTime;
    private int ticksPerbeat = 24;


    public void startRecording() {
        try {
            lastRecordedSequence = new Sequence(Sequence.PPQ, this.ticksPerbeat);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException(e);
        }
        track = lastRecordedSequence.createTrack();

        this.prevTime = System.currentTimeMillis();
        this.tick = 0;


    }


    private long calculateTicks( long current, long prev){
        long ms = current - prev;
        double bpms = Player.getInstance().getBpm() / 60000.0;
        return (long) (ms * bpms * this.ticksPerbeat);
    }

    public void sequenceNote(int note, int velocity){
        if (lastRecordedSequence == null || track == null) return;

        currentTime = System.currentTimeMillis();
        this.tick += calculateTicks(currentTime, prevTime);

        track.add(Player.createNoteOnEvent(note, 9, velocity, tick));
        prevTime = currentTime;
    }

    public Sequence getLastRecordedSequence() {
        return lastRecordedSequence;
    }
}
