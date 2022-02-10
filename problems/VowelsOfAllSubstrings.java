/*
Problem:
Given a string word, return the sum of the number of vowels ('a', 'e', 'i', 'o', and 'u') in every substring of word.
A substring is a contiguous (non-empty) sequence of characters within a string.
Note: Due to the large constraints, the answer may not fit in a signed 32-bit integer. Please be careful during the calculations.

Link: https://leetcode.com/problems/vowels-of-all-substrings/

Solution:
We can use dp or simply use the concept:
For each vowels s[i],
it could be in the substring starting at s[x] and ending at s[y],
where 0 <= x <= i and i <= y < n,
that is (i + 1) choices for x and (n - i) choices for y.

So there are (i + 1) * (n - i) substrings containing s[i].
*/

import java.util.*;

public class VowelsOfAllSubstrings {
    public long countVowels(String word) {
        long n = word.length();
        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        long count = 0;

        for (int i = 0; i < n; i++) {
            if (vowels.contains(word.charAt(i))) {
                count += (i + 1) * (n - i);
            }
        }

        return count;
    }

    public long countVowelsDP(String word) {
        int n = word.length();
        long[] dp = new long[n + 1];
        long count = 0;

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            if ("aeiou".indexOf(word.charAt(i - 1)) >= 0) {
                dp[i] += i;
            }
            count += dp[i];
        }

        return count;
    }
}