package com.incubyte.kata;

public class StringCalculator {
    public static int add(String input){
        if (input == null || input.trim().isEmpty()){
            return 0;
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
