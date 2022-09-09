/*
Problem:
You are playing a game that contains multiple characters, and each of the characters has two main properties: 
attack and defense. You are given a 2D integer array properties where properties[i] = [attacki, defensei] represents 
the properties of the ith character in the game.

A character is said to be weak if any other character has both attack and defense levels strictly greater than 
this character's attack and defense levels. More formally, a character i is said to be weak if there exists 
another character j where attackj > attacki and defensej > defensei.

Return the number of weak characters.

Link: https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/

Solution:
Sort it according to one parameter, and just keep track of the other parameter
while iterating through the properties.
*/

import java.util.*;

public class TheNumberOfWeakCharactersInTheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        int maxDefense = Integer.MIN_VALUE, weakCount = 0;
        for (int[] property : properties) {
            if (maxDefense > property[1]) {
                weakCount++;
            }
            maxDefense = Math.max(property[1], maxDefense);
        }

        return weakCount;
    }
}
