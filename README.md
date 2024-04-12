# TGJCO-Apr2024

Text-based Dice Roller Challenge

## Objective:
Your task is to develop a text-based dice roller program in Java. The program should accept inputs in the format of "NdM", where N is the number of dice to roll, and M is the type of dice (e.g., 2d6 for rolling two six-sided dice). The program should support various types of dice, including d2, d3, d4, d6, d8, d10, d12, d20, and d100. Additionally, it should handle basic arithmetic operations such as addition (+), subtraction (-), and multiplication (*), including multiple dice rolls within a single expression.

Requirements:
Accept input in the format of "NdM" where N is the number of dice and M is the type of dice.
Support dice types: d2, d3, d4, d6, d8, d10, d12, d20, and d100.
Handle basic arithmetic operations: addition (+), subtraction (-), and multiplication (*) between dice rolls and constants.
Output should list every dice roll and the result of the expression.
Examples:

Input: 2d6
Output:
Rolls: 4, 6
Result: 10


Input: d20 + 5
Output:
Rolls: 12
Result: 17


Input: 3d4 * 1.5
Output:
Rolls: 1, 3, 4
Result: 12


Input: 2d10 + 3d8 - 5
Output:
Rolls: 7, 10, 2, 6, 1
Result: 21


Input: 2d13
Output: ERROR MESSAGE


## Optional features;
teams should implement as many of these as possible; All features should work together. Teams should carefully consider the schema for each feature and how they combine with different features.

### Roll history
* Allow for repeating of previous rolls

### Advantage/disadvantage
* Works with d20 and d100 dice.
* Optionally supports 2d10 and 3d6.
* Roll the dice twice and select the best or worst result.
* Can be stacked up to 3 times, resulting in a total of 4 dice; for instance, having 3 advantages involves rolling 4 dice and selecting the best result.

### Exploding dice
 * Works with d3, d4, d6, d8, d10, and d12.
 * Upon rolling the highest result, roll an additional die and add its value to the result.
 * For example, rolling 2d6 and getting 4 and 6 (5) results in a total of 15.
 * It should support both one-time exploding and unlimited exploding.
 * Penetrating dice, an optional feature, follows the same principle, but the additional dice contribute their total - 1 to the result.
 * For instance, rolling 2d6 and getting 4 and 6 (5) results in a total of 14.

### Target Number/dice pool
 * Works with d4, d6, d8, and d10.
 * Rolls a specified number of dice against a target number.
 * For instance, rolling 6d6 against a target of 5 yields results of 1, 2, 3, 4, 5, and 6, with a final result of 2.
  
### Opposed rolls
 * Works on d20, d100, 2d10, 3d6
 * Two rolls, attacker vs. defender result returns which result is highest
   
### Attack rolls with critical hits
 * Allows for D&D-style attack rolls with critical hits.
 * Supports attack rolls on d20 and d100.
 * Damage rolls can include one or more dice types: d3, d4, d6, d8, d10, and d12s.
 * Example: d20cs>19 + 5 / 1d8 + 2.
 * If the d20 result exceeds the critical strike range, both dice are rolled again to confirm the critical hit and calculate the total damage.
 * 19 / 5 & 15 / 6 result: 24 for 7, confirm: 20 for 15 total
