package com.incubyte.kata;

import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input){
        if (input == null || input.trim().isEmpty()){
            return 0;
        }
        if (input.startsWith("//")) {
            String[] parts = input.split("\n", 2);
            String delimiter = parts[0].substring(2);
            String numbersPart = parts[1];
            return sum(numbersPart.split(Pattern.quote(delimiter)));
        }
        String[] numbers = splitByDefaultDelimiters(input);
        return sum(numbers);
    }

    private static String[] splitByDefaultDelimiters(String input){
        return input.trim().split("[,\n]");
    }

    private static int sum(String[] numbers){
        int total = 0;
        for (String number : numbers){
            total += Integer.parseInt(number);
        }
        return total;
    }
}
