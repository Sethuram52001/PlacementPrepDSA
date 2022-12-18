/*
Problem:
You are given a 0-indexed string array words.

Two strings are similar if they consist of the same characters.

For example, "abca" and "cba" are similar since both consist of 
characters 'a', 'b', and 'c'.
However, "abacba" and "bcfd" are not similar since they do not consist 
of the same characters.
Return the number of pairs (i, j) such that 0 <= i < j <= word.length - 1 
and the two strings words[i] and words[j] are similar.

Link: https://leetcode.com/problems/count-pairs-of-similar-strings/description/

Solution:
Bit-masking: We can group the similar words using the bit masks, and then count the pairs.
*/

import java.util.*;

public class CountPairsOfSimilarStrings {
    public int similarPairs(String[] words) {
        Map<Integer, Integer> map = new HashMap<>();
        for(String word : words) {
            int key = transform(word);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        int similarPairs = 0;
        for(Integer key : map.keySet()) {
            int freq = map.get(key);
            similarPairs += freq*(freq-1);
        }

        return similarPairs/2;
    }

    private int transform(String word) {
        int res = 0;
        for(char ch : word.toCharArray()) {
            res = res | (1 << (ch - 'a'));
        }

        return res;
    }    
}
