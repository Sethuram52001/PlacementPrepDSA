/*
Problem:
The power of the string is the maximum length of a non-empty substring that contains only one unique character.
Given a string s, return the power of s.

Link: https://leetcode.com/problems/consecutive-characters/
*/

public class ConsecutiveCharacters {
    private static int maxPower(String s) {
        int max = 1;
        int curr = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                curr++;
            } else {
                max = Math.max(curr, max);
                curr = 1;
            }
        }

        return Math.max(max, curr);
    }
}