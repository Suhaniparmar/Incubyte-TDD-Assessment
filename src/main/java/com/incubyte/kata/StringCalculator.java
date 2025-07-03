package com.incubyte.kata;

public class StringCalculator {
    public static int add(String input) {
        if (input == null || input.trim().isEmpty()){
            return 0;
        }
        if (input.contains(",")) {
            String[] parts = input.split(",");
            return Integer.parseInt(parts[0].trim()) + Integer.parseInt(parts[1].trim());
        }
        return parseSingleNumber(input);
    }

    private static int parseSingleNumber(String input){
        return Integer.parseInt(input.trim());
    }

}
