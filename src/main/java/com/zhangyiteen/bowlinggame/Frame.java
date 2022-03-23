package com.zhangyiteen.bowlinggame;

public class Frame {
    private int numberOfKnockDown;
    private int rollCounter;
    private int needBonus;
    private int score;
    private int frameId;
    
    public Frame() {
        rollCounter = 0;
        numberOfKnockDown = 0;
        needBonus = 0;
        score = 0;
        frameId = 0;
    }

    public void roll(int knockDowns, int frameId) {
        this.frameId = frameId;
        this.numberOfKnockDown += knockDowns;
        rollCounter++;
        
        // not the last frame, the last frame has no bonus
        if(this.frameId != 10) { 
            if (this.numberOfKnockDown == 10){  //a strike or a spare
                if (rollCounter == 1){ //all 10 pins dropped down by one time shotting
                    this.needBonus = 2; //strike, the next two rolls are bonus
                } else { //10 pins are dropped down by two times of shotting
                    this.needBonus = 1; //spare, next roll is bonus
                }
            }
        } // the 10th frame has no bonus
        this.score = this.numberOfKnockDown;
    }

    public int getKnockDowns() {
        return this.numberOfKnockDown;
    }

    public void updateBonus(int bonus) {
        if (this.needBonus > 0){
            this.score += bonus;
            this.needBonus--;
        }
    }

    public int getScore() {
        return this.score;
    }

    protected int numberOfBonus() {
        return needBonus;
    }
}