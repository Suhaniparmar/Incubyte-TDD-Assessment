package com.incubyte.kata;

import java.util.regex.Pattern;

public class StringCalculator {
    public static int add(String input){
        if(input == null || input.trim().isEmpty()){
            return 0;
        }
        String[] numbers;
        if(hasCustomDelimiter(input)){
            numbers = extractNumbersWithCustomDelimiter(input);
        }else{
            numbers = splitByDefaultDelimiters(input);
        }
        return sum(numbers);
    }

    private static boolean hasCustomDelimiter(String input){
        return input.startsWith("//");
    }

    private static String[] extractNumbersWithCustomDelimiter(String input){
        String[] parts = input.split("\n", 2);
        String delimiter = parts[0].substring(2); // extract custom delimiter
        String numbersPart = parts[1];
        return numbersPart.split(Pattern.quote(delimiter));
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
