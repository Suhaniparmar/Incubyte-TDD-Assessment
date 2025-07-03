package com.incubyte.kata;

public class StringCalculator {
    public static int add(String input){
        if (input == null || input.trim().isEmpty()){
            return 0;
        }
        if (input.contains(",")){
            return sumTwoNumbers(input);
        }
        return parseSingleNumber(input);
    }

    private static int parseSingleNumber(String input){
        return Integer.parseInt(input.trim());
    }

    private static int sumTwoNumbers(String input){
        String[] parts = input.split(",");
        int num1 = parseSingleNumber(parts[0]);
        int num2 = parseSingleNumber(parts[1]);
        return num1 + num2;
    }
}
