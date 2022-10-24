/*
Problem:
You are given an array of strings arr. A string s is formed by the concatenation of a subsequence of arr that has unique characters.
Return the maximum possible length of s.

A subsequence is an array that can be derived from another array by deleting some or no elements without changing the order of the 
remaining elements.

Link: https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/

Solution:
We can try out all combinations by masking the characters in the present combination while trying out
new combinations by concatenating.
*/

import java.util.*;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters {
    public int maxLength(List<String> arr) {
        int maxLen = 0;
        List<String> combinations = new ArrayList<>();
        combinations.add("");

        for (String s : arr) {
            if (!isUnique(s)) {
                continue;
            }

            List<String> newCombinations = new ArrayList<>();
            for (String combination : combinations) {
                String temp = combination + s;
                if (isUnique(temp)) {
                    newCombinations.add(temp);
                    maxLen = Math.max(temp.length(), maxLen);
                }
            }
            combinations.addAll(newCombinations);
        }

        return maxLen;
    }

    private boolean isUnique(String s) {
        if (s.length() > 26) {
            return false;
        }

        boolean[] charSet = new boolean[26];
        for (char ch : s.toCharArray()) {
            if (charSet[ch - 'a']) {
                return false;
            }
            charSet[ch - 'a'] = true;
        }

        return true;
    }
}
