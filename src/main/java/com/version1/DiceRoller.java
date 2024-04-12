package com.version1;

import com.version1.Exceptions.InvalidDieException;
import com.version1.Exceptions.InvalidOperandException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.IntStream;

public class DiceRoller {

    Map<Integer, Boolean> VALID_DICE = new HashMap<>(){{
        put(2, true);
        put(3, true);
        put(4, true);
        put(6, true);
        put(8, true);
        put(10, true);
        put(12, true);
        put(20, true);
        put(100, true);
    }};

    public static void main(String[] args) throws IOException {
        DiceRoller diceRoller = new DiceRoller();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            System.out.println("Enter your Attack Roles below");
            String input = reader.readLine();

            try {
                String expression = diceRoller.convertInputToAnExpression(input);
                System.out.println(diceRoller.stringCalculator(expression));
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public List<Integer> interpretDiceRoll(String input) throws InvalidDieException {
        //E.g. 3d2
        List<Integer> diceRolls = new ArrayList<>();

        String[] arr = input.split("d");
        int numberOfRolls = Integer.parseInt(arr[0]);
        int howManySides = Integer.parseInt(arr[1]);

        if(!VALID_DICE.containsKey(howManySides)){
            throw new InvalidDieException(howManySides + " is not a valid die");
        }

        Random random = new Random();
        for(int i=0; i<numberOfRolls; i++) {
            int roll = random.nextInt(howManySides) + 1;
            diceRolls.add(roll);
            System.out.println("You rolled a " + roll);
        }
        return diceRolls;
    }

    public String convertInputToAnExpression(String input) {
        String[] parts = input.split(" ");
        String expressionAsASum = input;

        for(String part : parts) {
            if(part.contains("d")){
                int sum = interpretDiceRoll(part).stream().mapToInt(Integer::intValue).sum();
                expressionAsASum = expressionAsASum.replaceFirst(part, Integer.toString(sum));
            }
        }

        return expressionAsASum;
    }

    public Integer stringCalculator(String expression) throws InvalidOperandException {
        String[] parts = expression.split(" ");
        int total = Integer.parseInt(parts[0]);

        for(int i=1; i<parts.length; i+=2){
            String operator = parts[i];
            int num = Integer.parseInt(parts[i+1]);

            switch (operator){
                case "+":
                    total += num;
                    break;

                case "-":
                    total -= num;
                    break;

                case "*":
                    total *= num;
                    break;

                default:
                    throw new InvalidOperandException("Invalid operand entered: " + operator);
            }
        }

        return total;
    }

}
