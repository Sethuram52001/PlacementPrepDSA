/*
Problem:
A message containing letters from A-Z can be encoded into numbers using the following mapping:

'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse 
of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:

"AAJF" with the grouping (1 1 10 6)
"KJF" with the grouping (11 10 6)
Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different 
from "06".

Given a string s containing only digits, return the number of ways to decode it.

Link: https://leetcode.com/problems/decode-ways/

Solution:
DP - we can do top-down approach, as we know that
s.length() == idx will result in 1 possible decoding
and we know the recurrence relations are:
ans = decode(s, idx + 1)
ans = decode(s, idx + 2) // if happens to be within 10 to 26
*/

import java.util.*;

public class DecodeWays {
    HashMap<Integer, Integer> map;

    public int numDecodings_Tabulation(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i + 1];
            if (i <= s.length() - 2 && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
                dp[i] += dp[i + 2];
            }
        }

        return dp[0];
    }

    public int numDecodings(String s) {
        map = new HashMap<>();
        return numDecodings(s, 0);
    }

    private int numDecodings(String s, int idx) {
        if (map.containsKey(idx)) {
            return map.get(idx);
        }

        if (idx == s.length()) {
            return 1;
        }

        if (s.charAt(idx) == '0') {
            return 0;
        }

        int ans = numDecodings(s, idx + 1);
        if (idx < s.length() - 1 && (s.charAt(idx) == '1' || s.charAt(idx) == '2' && s.charAt(idx + 1) < '7')) {
            ans += numDecodings(s, idx + 2);
        }

        map.put(idx, ans);

        return ans;
    }
}