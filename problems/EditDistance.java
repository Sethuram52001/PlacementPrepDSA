/*
Problem:
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

Link: https://leetcode.com/problems/edit-distance/

Solution:
Insert = 1 + func(word1, word2, idx1, idx2 + 1)
Delete = 1 + func(word1, word2, idx1 + 1, idx2)
replace = 1 + func(word1, word2, idx1 + 1, idx2 + 1)
*/

public class EditDistance {
    public int minDistance_(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                }
            }
        }

        return dp[len1][len2];
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return solve(word1, word2, 0, 0, dp);
    }

    private int solve(String word1, String word2, int idx1, int idx2, int[][] dp) {
        if (idx1 == word1.length()) {
            return word2.length() - idx2;
        }
        if (idx2 == word2.length()) {
            return word1.length() - idx1;
        }

        if (dp[idx1][idx2] != -1) {
            return dp[idx1][idx2];
        }

        if (word1.charAt(idx1) == word2.charAt(idx2)) {
            dp[idx1][idx2] = solve(word1, word2, idx1 + 1, idx2 + 1, dp);
            return dp[idx1][idx2];
        }

        else {
            int replace = 1 + solve(word1, word2, idx1 + 1, idx2 + 1, dp);
            int delete = 1 + solve(word1, word2, idx1 + 1, idx2, dp);
            int add = 1 + solve(word1, word2, idx1, idx2 + 1, dp);

            dp[idx1][idx2] = Math.min(Math.min(replace, delete), add);
            return dp[idx1][idx2];
        }
    }
}