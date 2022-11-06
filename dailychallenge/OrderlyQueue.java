/*
Problem:
You are given a string s and an integer k. You can choose one of the first k letters of s and append it at 
the end of the string..

Return the lexicographically smallest string you could have after applying the mentioned step any number of moves.

Link: https://leetcode.com/problems/orderly-queue/

Solution:
if k == 1:
Rotating the array and try every combination.

if k > 1:
We can now pick any letter from the first k letters, so we can basically
sort the letters of the string.
*/

import java.util.*;

public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if (k == 1) {
            return rotate(s);
        }

        return sort(s);
    }

    private String rotate(String s) {
        String minStr = s;
        String newStr = s;
        for (int i = 0; i < s.length() - 1; i++) {
            newStr = newStr.substring(1) + newStr.substring(0, 1);
            if (newStr.compareTo(minStr) < 0) {
                minStr = newStr;
            }
        }

        return minStr;
    }

    private String sort(String s) {
        char[] str = s.toCharArray();
        Arrays.sort(str);
        return new String(str);
    }
}
