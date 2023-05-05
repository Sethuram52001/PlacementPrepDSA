/*
Problem:
Given a string s and an integer k, return the maximum number of vowel letters in any substring of s with length k.
Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Link: https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/

Solution: 
Sliding window - keep track of the number of vowels in each window of substring.
*/

import java.util.*;

public class MaximumNumberOfVowelsInASubstringOfGivenLength {
    public int maxVowels(String s, int k) {
        int max = 0, count = 0;
        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

        for (int idx = 0; idx < k; idx++) {
            char ch = s.charAt(idx);
            if (vowels.contains(ch)) {
                count++;
            }
        }
        max = count;

        for (int idx = k; idx < s.length(); idx++) {
            if (max == k) {
                return k;
            }
            char firstChar = s.charAt(idx - k);
            if (vowels.contains(firstChar)) {
                count--;
            }
            if (vowels.contains(s.charAt(idx))) {
                count++;
            }
            max = Math.max(count, max);
        }

        return max;
    }
}
