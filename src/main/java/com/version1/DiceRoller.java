package com.version1;

import com.version1.Exceptions.InvalidDieException;

import java.util.*;

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

    Map<String, Boolean> VALID_OPERAND = new HashMap<>(){{
        put("+", true);
        put("-", true);
        put("*", true);
    }};

    public static void main(String[] args) {
        // Placeholder for user input handling
        String userInput = "2d6 + 3"; // Example input
        DiceExpression expression = new DiceExpression(userInput);
        expression.evaluate();
    }

    public void rollDice(String input) {

    }

    public List<Integer> interpretDiceRoll(String input){
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
            diceRolls.add(random.nextInt(howManySides) + 1);
        }

        return diceRolls;
    }

public String interpretStatement(String input){
        if(!VALID_OPERAND.containsKey(input)){
            int sum = 0;
            List<Integer> results = interpretDiceRoll(input);
            for (int i = 0; i < results.length(); i++) {
                sum += results[i];
            }
        } else
        {
            return "";
        }
}


}
