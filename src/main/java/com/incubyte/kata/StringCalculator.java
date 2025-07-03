package com.incubyte.kata;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.trim().isEmpty()){
            return 0;
        }
        return parseSingleNumber(input);
    }

    private static int parseSingleNumber(String input){
        return Integer.parseInt(input.trim());
    }
}
