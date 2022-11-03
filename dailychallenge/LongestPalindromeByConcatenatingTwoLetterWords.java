/*
Problem:
You are given an array of strings words. Each element of words consists of two lowercase English letters.
Create the longest possible palindrome by selecting some elements from words and concatenating them in any order. 
Each element can be selected at most once.
Return the length of the longest palindrome that you can create. If it is impossible to create any palindrome, 
return 0.
A palindrome is a string that reads the same forward and backward.

Link: https://leetcode.com/problems/longest-palindrome-by-concatenating-two-letter-words/

Solution:
A palindrome must be mirrored over the center. Suppose we have a palindrome. If we prepend the word "ab" on the left, 
what must we append on the right to keep it a palindrome?
We must append "ba" on the right. The number of times we can do this is the minimum of (occurrences of "ab") and (occurrences of "ba").
For words that are already palindromes, e.g. "aa", we can prepend and append these in pairs as described in the previous hint. 
We can also use exactly one in the middle to form an even longer palindrome.
*/

import java.util.*;

public class LongestPalindromeByConcatenatingTwoLetterWords {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        boolean center = false;
        int longestPal = 0;
        for (String word : freqMap.keySet()) {
            int countOfWord = freqMap.get(word);
            if (word.charAt(0) == word.charAt(1)) {
                if (countOfWord % 2 == 0) {
                    longestPal += countOfWord;
                } else {
                    longestPal += countOfWord - 1;
                    center = true;
                }
            } else if (word.charAt(0) < word.charAt(1)) {
                String rev = new StringBuilder(word).reverse().toString();
                if (freqMap.containsKey(rev)) {
                    longestPal += 2 * Math.min(countOfWord, freqMap.get(rev));
                }
            }
        }

        if (center) {
            longestPal++;
        }

        return longestPal * 2;
    }
}