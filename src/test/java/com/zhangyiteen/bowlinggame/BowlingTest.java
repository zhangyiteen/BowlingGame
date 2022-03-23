package com.zhangyiteen.bowlinggame;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import java.util.stream.Stream;
/**
 * Unit test for simple App.
 */
// @RunWith(Parameterized.class)
public class BowlingTest 
{
    private Bowling bowling;

    static Stream<Arguments> generateData() {
        return Stream.of(
            Arguments.of(85, Arrays.asList(new Integer[] {3,5,7,2,3,5,7,2,3,5,7,2,3,5,7,2,3,5,7,2})),
            // 1 strike
            Arguments.of(94, Arrays.asList(new Integer[] {3,5,10,3,5,7,2,3,5,7,2,3,5,7,2,3,5,7,2})),
            // 1 spare and 1 strike
            Arguments.of(106, Arrays.asList(new Integer[] {3,7,10,3,5,7,2,3,5,7,2,3,5,7,2,3,5,7,2})),
            // two consecutive strike, no strike/spare in 10th frame
            Arguments.of(126, Arrays.asList(new Integer[] {3,7,10,10,7,2,3,5,7,2,3,5,7,2,3,5,7,2})),
            // two consecutive strike, 3 rolls in 10th frame
            Arguments.of(137, Arrays.asList(new Integer[] {3,7,10,10,7,2,3,5,7,2,3,5,7,2,3,5,10,2,8})),
            // full score
            Arguments.of(300, Arrays.asList(new Integer[] {10,10,10,10,10,10,10,10,10,10,10,10})),
             // special spare, the 1st roll null pin has been knocked down, but 2nd roll all pins have been knocked down
            Arguments.of(115, Arrays.asList(new Integer[] {0,10,10,3,7,2,5,2,3,2,6,7,1,8,1,10,2,6}))
        );
    }

    @ParameterizedTest
    @MethodSource("generateData")
    public void testNoSpareNoStrike(int expected, List<Integer> inputValue)
    {
        System.out.println(inputValue);
        bowling = new Bowling();
        for (Integer i : inputValue) {
            bowling.roll(i.intValue());
        }
        assertEquals(expected, bowling.getScore());
    }
}