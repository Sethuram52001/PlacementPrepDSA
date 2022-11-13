/*
Problem:
Given the integers zero, one, low, and high, we can construct a string by starting with an empty string, and then at 
each step perform either of the following:
Append the character '0' zero times.
Append the character '1' one times.
This can be performed any number of times.
A good string is a string constructed by the above process having a length between low and high (inclusive).
Return the number of different good strings that can be constructed satisfying these properties. Since the answer can 
be large, return it modulo 10^9 + 7.

Link: https://leetcode.com/problems/count-ways-to-build-good-strings/description/

Solution:
Dynamic programming: We know that there is 1 possibility for word to formed when size is 0.
Now, we count the possibilities for every combination by the following:
dp[no_of_chars] = dp[no_of_chars] + dp[no_of_chars - zero]
dp[no_of_chars] = dp[no_of_chars] + dp[no_of_chars - one]
res = res + dp[no_of_chars] 
*/

public class CountWaysToBuildGoodStrings {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] dp = new int[high + 1];
        int mod = 1_000__000__007;

        int goodStrings = 0;
        dp[0] = 1;
        for (int chars = 1; chars <= high; chars++) {
            if (chars >= zero) {
                dp[chars] = (dp[chars] + dp[chars - zero]) % mod;
            }
            if (chars >= one) {
                dp[chars] = (dp[chars] + dp[chars - one]) % mod;
            }
            if (chars >= low) {
                goodStrings = (goodStrings + dp[chars]) % mod;
            }
        }

        return goodStrings;
    }
}