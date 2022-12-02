/*
Problem:
Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and 
do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.

Link: https://leetcode.com/problems/determine-if-two-strings-are-close/description/

Solution:
Check if both words contain same alphabets and now sort the frequencies and check if they match.
If count of frequencies match, then we can interchange alphabets and make the transformation as
stated in the question.
*/

import java.util.*;

public class DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        int len = 26;
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int idx = 0; idx < word1.length(); idx++) {
            freq1[word1.charAt(idx) - 'a']++;
            freq2[word2.charAt(idx) - 'a']++;
        }

        for (int i = 0; i < len; i++) {
            if (freq1[i] == freq2[i]) {
                continue;
            }

            if (freq1[i] == 0 || freq2[i] == 0) {
                return false;
            }
        }

        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int idx = 0; idx < len; idx++) {
            if (freq1[idx] != freq2[idx]) {
                return false;
            }
        }

        return true;
    }
}
