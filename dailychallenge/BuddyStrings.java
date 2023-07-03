/*
Problem:
Given two strings s and goal, return true if you can swap two letters in s so the result is equal to goal, 
otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the 
characters at s[i] and s[j].

For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

Link: https://leetcode.com/problems/buddy-strings/description/

Solution:
* We can say if the length of both strings are not of same length, then it is not possible.
* If both strings are equal, check for duplicate characters if not, it is not possible.
* Else, check if both differ only by 2 characters and both of these characters are interchangable to give 
the same string.
*/

public class BuddyStrings {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        // s == goal, then check for duplicate characters, because only in that case we can swap and still achieve it
        if (s.equals(goal)) {
            int[] count = new int[26];
            for (char ch : s.toCharArray()) {
                count[ch - 'a']++;
            }
            for (int freq : count) {
                if (freq > 1) {
                    return true;
                }
            }
            return false;
        } else {
            int first = -1, second = -1;
            for (int idx = 0; idx < s.length(); idx++) {
                if (s.charAt(idx) != goal.charAt(idx)) {
                    if (first == -1) {
                        first = idx;
                    } else if (second == -1) {
                        second = idx;
                    } else {
                        return false;
                    }
                }
            }
            return second != -1 && s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first);
        }
    }
}
