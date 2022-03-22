package com.zhangyiteen.bowlinggame;

import java.util.ArrayList;
import com.zhangyiteen.bowlinggame.Frame;

public class Bowling {
    private int frameCounter;
    private ArrayList<Frame> frames;
    private int rollCounter;

    public Bowling() {
        rollCounter = 0;
        frameCounter = 0;
        this.frames = new ArrayList<Frame>(10);
        this.frames.add(new Frame());
    }

    // get the total score
    public int getScore() {
        int score = 0;
        for (Frame frame : this.frames) {
            score += frame.getScore();
        }
        return score;
    }

    public void roll(int n) {
        if (frameCounter != 9){
            _roll(n);
        } else {
            roll_last(n);
        }
    }

    // roll in the first 9 frame
    private void _roll(int n) {

        //get the current frame regarding to the frameCounter
        Frame frame = this.frames.get(this.frameCounter);
        
        frame.roll(n, this.frameCounter);

        //if the previous frame is strike or spare, update the bonus
        //for strike, it requires two rolls as bonus
        //for spare, it requires one roll as bonus
        //if frame (n-2) is a strike, it requires next two roll which is two roll in frame (n-1)
        //but, the frame (n-1) can be a strike, so frame (n-2) can only get one bonus in frame (n-1) and need one roll in frame (n)
        if (this.frameCounter >= 1)
            this.frames.get(this.frameCounter-1).updateBonus(n);
        if (this.frameCounter >= 2)
            this.frames.get(this.frameCounter-2).updateBonus(n);

        // print(this.frameCounter, frame.getScore())
        
        this.rollCounter += 1;
        if (n == 10 && this.rollCounter == 1) { // if strike, start a new frame
            this.rollCounter = 0;
            this.frameCounter += 1;
            this.frames.add(new Frame());
        }
        
        if (this.rollCounter >= 2) { // if two rolls, new frame
            this.rollCounter = 0;
            this.frameCounter += 1;
            this.frames.add(new Frame());
        }
    }

    // roll in the last frame
    private void roll_last(int n) {
        this.rollCounter += 1;
        
        //the last frame can have maximum 3 rolls
        if (this.rollCounter > 3){
            throw new IllegalArgumentException("error: more than 3 rolls in 10th frame");
        }
            
        Frame frame = this.frames.get(this.frameCounter);
        if (frame.getScore() < 10 && this.rollCounter > 2){
            throw new IllegalArgumentException("error: no extra roll");          
        }
        frame.roll(n, this.frameCounter);
        // print(self.frame_counter, frame.getScore())
        this.frames.get(this.frameCounter-1).updateBonus(n);
        this.frames.get(this.frameCounter-2).updateBonus(n);
    }
}
