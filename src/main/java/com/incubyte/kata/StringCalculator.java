package com.incubyte.kata;

public class StringCalculator {
    public static int add(String input){
        if (input == null || input.trim().isEmpty()){
            return 0;
        }
        if (input.contains(",")){
            return sumCommaSeparatedNumbers(input);
        }
        return parseSingleNumber(input);
    }

    private static int parseSingleNumber(String input){
        return Integer.parseInt(input.trim());
    }

    private static int sumCommaSeparatedNumbers(String input){
        String[] parts = input.split(",");
        int sum = 0;
        for (String part : parts) {
            sum += Integer.parseInt(part.trim());
        }
        return sum;
    }
}
