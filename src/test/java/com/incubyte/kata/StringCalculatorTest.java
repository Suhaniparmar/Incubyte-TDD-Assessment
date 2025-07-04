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
        assertEquals(0, StringCalculator.add("0"));
        assertEquals(1000, StringCalculator.add("1000"));
    }

    @Test
    public void returnSumForTwoCommaSeparatedNumbers(){
        assertEquals(5, StringCalculator.add("2,3"));
        assertEquals(113, StringCalculator.add("35,78"));
    }

    @Test
    public void returnSumForMultipleCommaSeparatedNumbers(){
        assertEquals(22, StringCalculator.add("1,5,7,9"));
        assertEquals(50, StringCalculator.add("1,6,5,10,16,12"));
    }

    @Test
    public void handleNewlineAsValidDelimiter() {
        assertEquals(10, StringCalculator.add("2\n5,3"));
        assertEquals(18, StringCalculator.add("2\n5,3\n8"));
    }

    @Test
    public void supportCustomSingleCharacterDelimiter() {
        assertEquals(3, StringCalculator.add("//;\n1;2"));
        assertEquals(10, StringCalculator.add("//#\n1#2#3#4"));
        assertEquals(18, StringCalculator.add("//@\n1@3@3@6@5"));
    }

    @Test
    public void throwExceptionForNegativeNumber() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> StringCalculator.add("1002,-4")
        );
        assertEquals("Negatives not allowed: -4", ex.getMessage());
    }

    @Test
    public void throwExceptionListingAllNegativeNumbers() {
        IllegalArgumentException ex = assertThrows(
                IllegalArgumentException.class,
                () -> StringCalculator.add("5,-7,4,-4,6")
        );
        assertEquals("Negatives not allowed: -7, -4", ex.getMessage());
    }

    @Test
    public void ignoreNumbersGreaterThanThousand() {
        assertEquals(8, StringCalculator.add("2,1001,6"));
        assertEquals(1008, StringCalculator.add("2,1001,1000,6"));
        assertEquals(5, StringCalculator.add("5,5000"));
    }

    @Test
    public void supportMultiCharacterDelimiter() {
        assertEquals(6, StringCalculator.add("//[***]\n1***2***3"));
        assertEquals(10, StringCalculator.add("//[<<]\n1<<2<<3<<4"));
        assertEquals(41, StringCalculator.add("//[||||]\n15||||23||||3"));
    }

    @Test
    public void supportMultipleSingleCharacterDelimiters() {
        assertEquals(6, StringCalculator.add("//[*][%]\n1*2%3"));
        assertEquals(19, StringCalculator.add("//[*][%][&]\n5*2%8&4"));
        assertEquals(8,  StringCalculator.add("//[^][#][!]\n2^2#2!2"));

    }

    @Test
    public void supportMultipleMultiCharacterDelimiters() {
        assertEquals(6, StringCalculator.add("//[***][%%]\n1***2%%3"));
        assertEquals(10, StringCalculator.add("//[+++][--][)))]\n1+++2--3)))4"));
        assertEquals(64, StringCalculator.add("//[$$][@@][:::]\n10$$3@@25:::26"));
    }


}
