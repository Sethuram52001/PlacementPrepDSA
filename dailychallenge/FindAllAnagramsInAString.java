/*
Problem:
Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Link: https://leetcode.com/problems/find-all-anagrams-in-a-string/

Solution:
Sliding window and hash
*/

import java.util.*;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        int window = p.length(), n = s.length();
        int[] pHash = new int[26];
        for (int i = 0; i < window; i++) {
            pHash[p.charAt(i) - 'a']++;
        }

        int left = 0, right = window - 1;
        int[] sHash = new int[26];

        List<Integer> res = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            sHash[s.charAt(i) - 'a']++;
        }

        while (right < n) {
            if (isValidAnagram(sHash, pHash)) {
                res.add(left);
            }

            sHash[s.charAt(left) - 'a']--;
            left++;
            right++;
            if (right < n) {
                sHash[s.charAt(right) - 'a']++;
            }
        }

        return res;
    }

    private boolean isValidAnagram(int[] sHash, int[] pHash) {
        for (int i = 0; i < 26; i++) {
            if (sHash[i] != pHash[i]) {
                return false;
            }
        }
        return true;
    }
}