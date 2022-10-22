/*
Problem:
Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that 
every character in t (including duplicates) is included in the window. If there is no such substring, return 
the empty string "".

The testcases will be generated such that the answer is unique.

A substring is a contiguous sequence of characters within the string.

Link: https://leetcode.com/problems/minimum-window-substring/

Solution:
Use two pointers to create a window of letters in s, which would have all the characters from t.
*/

import java.util.*;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for (char ch : t.toCharArray()) {
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }

        String minWin = null;
        int left = 0, right = 0, required = tmap.size(), currFormed = 0;
        Map<Character, Integer> smap = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            smap.put(ch, smap.getOrDefault(ch, 0) + 1);

            if (tmap.containsKey(ch) && smap.get(ch).intValue() == tmap.get(ch).intValue()) {
                currFormed++;
            }

            while (left <= right && currFormed == required) {
                ch = s.charAt(left);
                if (minWin == null || minWin.length() > right - left + 1) {
                    minWin = s.substring(left, right + 1);
                }
                smap.put(ch, smap.get(ch) - 1);
                if (tmap.containsKey(ch) && smap.get(ch).intValue() < tmap.get(ch).intValue()) {
                    currFormed--;
                }
                left++;
            }

            right++;
        }

        return minWin == null ? "" : minWin;
    }
}
