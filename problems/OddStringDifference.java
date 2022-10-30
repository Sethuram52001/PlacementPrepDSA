/*
Problem:
You are given an array of equal-length strings words. Assume that the length of each string is n.

Each string words[i] can be converted into a difference integer array difference[i] of length n - 1 where 
difference[i][j] = words[i][j+1] - words[i][j] where 0 <= j <= n - 2. Note that the difference between two 
letters is the difference between their positions in the alphabet i.e. the position of 'a' is 0, 'b' is 1, 
and 'z' is 25.

For example, for the string "acb", the difference integer array is [2 - 0, 1 - 2] = [2, -1].
All the strings in words have the same difference integer array, except one. You should find that string.

Return the string in words that has different difference integer array.

Link: https://leetcode.com/problems/odd-string-difference/

Solution:
We can simply check one word at a time and the difference, by maintaining
separate variables for the difference and word which contributed that difference.
*/

import java.util.*;

public class OddStringDifference {
    public String oddString(String[] words) {
        int[] key1 = new int[] { 50, 40 };
        int[] key2 = new int[] { 40, 40 };
        String wordKey1 = "", wordKey2 = "";

        for (String word : words) {
            int[] diff = calcDifference(word);
            if (wordKey1.equals("")) {
                key1 = diff;
                wordKey1 = word;
            } else if (wordKey2.equals("") && !Arrays.equals(key1, diff)) {
                key2 = diff;
                wordKey2 = word;
            } else if (Arrays.equals(key1, diff) && !wordKey2.equals("")) {
                return wordKey2;
            } else if (Arrays.equals(key2, diff)) {
                return wordKey1;
            }
        }

        return wordKey2;
    }

    private int[] calcDifference(String word) {
        int[] diff = new int[word.length() - 1];
        for (int i = 0; i < word.length() - 1; i++) {
            diff[i] = (word.charAt(i + 1) - 'a') - (word.charAt(i) - 'a');
        }

        return diff;
    }
}
