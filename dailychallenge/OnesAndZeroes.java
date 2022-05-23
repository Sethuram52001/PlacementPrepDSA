/*
Problem:
You are given an array of binary strings strs and two integers m and n.
Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
A set x is a subset of a set y if all elements of x are also elements of y.

 
Link: https://leetcode.com/problems/ones-and-zeroes/

Solution:
DP - we will decide at some ith index between options which gives us the best result:
1 . if i use decide to build this string then 
	 answerFor( next index , currAvailableZeros - currentStringZeros , currAvailableOnes - currentStringOnes )
2. if i dont decide to build this string ( assuming i will get better answer later, if i save available zeros and ones)
	 answerFor( next index , currAvailableZeros , currAvailableOnes  )
	 
ans_for_ith = maxOf ( if i build this current string , if i dont build )
*/

public class OnesAndZeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = countZeros(str);
            int ones = str.length() - zeros;
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }

        return dp[m][n];
    }

    private int countZeros(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (ch == '0') {
                count++;
            }
        }
        return count;
    }
}