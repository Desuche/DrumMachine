package nl.vu.cs.softwaredesign.beat;

import java.util.Stack;

public class BeatCommandHistory {
    private Stack<BeatCommand> history = new Stack<>();

    public void push(BeatCommand command){
        this.history.push(command);
    }

    public BeatCommand pop(){
        return this.history.pop();
    }

    public void remove(BeatCommand beatCommand){
        this.history.remove(beatCommand);
    }

    public boolean isEmpty(){
        return this.history.isEmpty();
    }
}
