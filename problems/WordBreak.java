/*
Problem:
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one 
or more dictionary words.
Note that the same word in the dictionary may be reused multiple times in the segmentation.

Link: https://leetcode.com/problems/word-break/

Solution:
dp - can construct problem
*/

import java.util.*;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        
        for(int i = 0; i <= n; i++) {
            if(dp[i]) {
                for(String word : wordDict) {
                    if(word.length() <= n - i && s.substring(i, i + word.length()).equals(word)) {
                        dp[i + word.length()] = true;
                    }
                }
            }
        }
        
        return dp[n];
    }    
}