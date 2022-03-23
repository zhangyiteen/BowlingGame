package com.zhangyiteen.bowlinggame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for class Frame.
 */
public class FrameTest 
{
    /**
     * Rigorous Test :-)
     */
    private Frame frame;

    @Before
    public void setup() {
        frame = new Frame();
    }

    @Test
    public void testRoll()
    {
        frame.roll(2, 0);
        frame.roll(3, 0);
        assertEquals(5, frame.getScore());
        assertEquals(0, frame.numberOfBonus());
        // assertTrue( true );
    }

    @Test
    public void testRollForStrike()
    {
        frame.roll(10, 0);
        assertEquals(10, frame.getScore());
        assertEquals(2, frame.numberOfBonus());
    }

    @Test
    public void testRollForSpare()
    {
        frame.roll(3, 0);
        frame.roll(7, 0);
        assertEquals(10, frame.getScore());
        assertEquals(1, frame.numberOfBonus());
    }

    @Test
    public void testRollForSpare_0_10()
    {
        frame.roll(0, 0);
        frame.roll(10, 0);
        assertEquals(10, frame.getScore());
        assertEquals(1, frame.numberOfBonus());
    }
}