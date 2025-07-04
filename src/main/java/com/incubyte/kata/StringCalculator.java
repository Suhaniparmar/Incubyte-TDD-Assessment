package com.incubyte.kata;


import java.util.ArrayList;
import java.util.List;
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
        String delimiterPart = parts[0].substring(2);

        String delimiter;
        if (delimiterPart.startsWith("[") && delimiterPart.endsWith("]")) {
            delimiter = delimiterPart.substring(1, delimiterPart.length() - 1);
            delimiter = Pattern.quote(delimiter);  // to avoid regex char, consider as a string literal
        } else {
            delimiter = Pattern.quote(delimiterPart);
        }

        String numbersPart = parts[1];
        return numbersPart.split(delimiter);
    }

    private static String[] splitByDefaultDelimiters(String input){
        return input.trim().split("[,\n]");
    }

    private static int sum(String[] numbers){
        int total = 0;
        List<String> negatives = new ArrayList<>();

        for (String number : numbers){
            int num = Integer.parseInt(number);
            if(num < 0) {
                negatives.add(number);
            }else if(num <= 1000){
                total += num;
            }
        }

        if (!negatives.isEmpty()) {
            throw new IllegalArgumentException("Negatives not allowed: " + String.join(", ", negatives));
        }
        return total;
    }
}
