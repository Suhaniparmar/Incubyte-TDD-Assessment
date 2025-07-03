package com.incubyte.kata;

public class StringCalculator {
    public static int add(String input) {
        if(input.equals("")){
            return 0;
        }
        return Integer.parseInt(input);
    }
}
