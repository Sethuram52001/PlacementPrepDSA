/*
Problem:
Given two strings word1 and word2, return the minimum number of steps required to make 
word1 and word2 the same.

In one step, you can delete exactly one character in either string.

Link: https://leetcode.com/problems/delete-operation-for-two-strings/

Solution:
We make use of a 2-D dpdp array. Now, dp[i][j] refers to the number of deletions required to equalize the two strings 
if we consider the strings' length upto (i−1)th index and (j-1)th
index for s1 and s2 respectively. Again, we fill in the dp array in a row-by-row order. Now, in order to fill the 
entry for dp[i][j], we need to consider two cases only:

The characters s1[i-1] and s2[j−1] match with each other. In this case, we need to replicate the entry 
corresponding to dp[i−1][j−1] itself. This is because, the matched character doesn't need to be deleted from any of the strings.

The characters s1[i−1] and s2[j−1] don't match with each other. In this case, we need to delete either 
the current character of s1 or s2. Thus, an increment of 1 needs to be done relative to the entries corresponding 
to the previous indices. The two options available at this moment are dp[i-1][j] and dp[i][j-1]. 
Since, we are keeping track of the minimum number of deletions required, we pick up the minimum out of these two values.

At the end, dp[m][n] gives the required minimum number of deletions. Here, mm and nn refer to the lengths of s1 and s2.
*/

public class DeleteOperationForTwoStrings {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }

        return dp[n][m];
    }
}