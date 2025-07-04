package com.incubyte.kata;

import org.junit.*;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void returnZeroForEmptyString(){
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void returnSameNumberForSingleValue(){
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void returnSumForTwoCommaSeparatedNumbers(){
        assertEquals(5, StringCalculator.add("2,3"));
    }

    @Test
    public void returnSumForMultipleCommaSeparatedNumbers(){
        assertEquals(22, StringCalculator.add("1,5,7,9"));
    }

}
