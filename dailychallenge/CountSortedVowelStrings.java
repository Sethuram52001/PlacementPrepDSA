/*
Problem:
Given an integer n, return the number of strings of length n that consist only of vowels (a, e, i, o, u) and 
are lexicographically sorted.

A string s is lexicographically sorted if for all valid i, s[i] is the same as or comes before s[i+1] in the 
alphabet.

Link: https://leetcode.com/problems/count-sorted-vowel-strings/

Solution:
dp[n][k] means the number of strings constructed by at most k different characters.

If k = 1, use only u
If k = 2, use only o,u
If k = 3, use only i,o,u
If k = 4, use only e,i,o,u
If k = 5, use only a,e,i,o,u

reference: i. https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918498/JavaC%2B%2BPython-DP-O(1)-Time-and-Space
           ii. https://leetcode.com/problems/count-sorted-vowel-strings/discuss/918507/Java-DP-O(n)-time-Easy-to-understand
*/

import java.util.*;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int a = 1, e = 1, i = 1, o = 1, u = 1;
        while (n-- > 1) {
            a = (a + e + i + o + u);
            e = (e + i + o + u);
            i = (i + o + u);
            o = (o + u);
            u = u;
        }

        return (a + e + i + o + u);
    }
    
    public int countVowelStringsDP(int n) {
        int[][] dp = new int[n + 1][6];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 5; j++) {
                if (i == 1) {
                    dp[i][j] = dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        for (int[] row : dp) {
            System.out.println(Arrays.toString(row));
        }

        return dp[n][5];
    }
}