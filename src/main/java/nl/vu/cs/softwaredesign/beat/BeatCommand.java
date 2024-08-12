package nl.vu.cs.softwaredesign.beat;

import nl.vu.cs.softwaredesign.grid.TrackVisual;

public class BeatCommand {
    private TrackVisual trackVisual;
    private Beat beat;

    public BeatCommand (Beat beat, TrackVisual trackVisual){
        this.trackVisual = trackVisual;
        this.beat = beat;
        this.beat.shape.setOnMouseClicked(event -> {
            trackVisual.removeBeat(this.beat);
            trackVisual.beatCommandHistory.remove(this);
        });
    }

    public boolean execute(){
        trackVisual.addBeat(beat);
        return true;
    }

    public void undo(){
        trackVisual.removeBeat(beat);
    }

}
