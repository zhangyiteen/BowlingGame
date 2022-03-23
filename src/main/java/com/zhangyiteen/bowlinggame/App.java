package com.zhangyiteen.bowlinggame;

import com.zhangyiteen.bowlinggame.Bowling;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // # no spare and strike
        int a[] = {3,5,7,2,3,5,7,2,3,5,7,2,3,5,7,2,3,5,7,2}; 

        // # 1 strike
        int b[] = {3,5,10,3,5,7,2,3,5,7,2,3,5,7,2,3,5,7,2};

        // # 1 spare and 1 strike
        int c[] = {3,7,10,3,5,7,2,3,5,7,2,3,5,7,2,3,5,7,2};

        // # two consecutive strike, no strike/spare in 10th frame
        int d[] = {3,7,10,10,7,2,3,5,7,2,3,5,7,2,3,5,7,2};

        // # two consecutive strike, 3 rolls in 10th frame
        int e[] = {3,7,10,10,7,2,3,5,7,2,3,5,7,2,3,5,10,2,8};

        // # full score 300
        int f[] = {10,10,10,10,10,10,10,10,10,10,10,10};

        // # special spare, the 1st roll null pin has been knocked down, but 2nd roll all pins have been knocked down
        int g[] = {0,10,10,3,7,2,5,2,3,2,6,7,1,8,1,10,2,6};

        Bowling bowling = new Bowling();

        for (int i : a) {
            bowling.roll(i);
        }

        //int score = bowling.getScore();    
        //System.out.println( score );
        bowling.printOutScoreAll();
    }
}
