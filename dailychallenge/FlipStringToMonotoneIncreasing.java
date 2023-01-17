/*
Problem:
A binary string is monotone increasing if it consists of some number of 0's (possibly none), 
followed by some number of 1's (also possibly none).

You are given a binary string s. You can flip s[i] changing it from 0 to 1 or from 1 to 0.

Return the minimum number of flips to make s monotone increasing.

Link: https://leetcode.com/problems/flip-string-to-monotone-increasing/description/ 

Solution:
Prefix-Suffix:
1. Skip 0's until we encounter the first 1.
2. Keep track of number of 1's in onesCount (Prefix).
3. Any 0 that comes after we encounter 1 can be a potential candidate for flip. Keep track of it in flipCount.
4. If flipCount exceeds oneCount - (Prefix 1's flipped to 0's)
a. Then we are trying to flip more 0's (suffix) than number of 1's (prefix) we have.
b. Its better to flip the 1's instead.

Reference: 
1. https://leetcode.com/problems/flip-string-to-monotone-increasing/solutions/183896/prefix-suffix-java-o-n-one-pass-solution-space-o-1/?orderBy=most_votes
*/

public class FlipStringToMonotoneIncreasing {
    public int minFlipsMonoIncr(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int oneCount = 0, flipCount = 0;
        for (int idx = 0; idx < s.length(); idx++) {
            if (s.charAt(idx) == '0') {
                if (oneCount == 0) {
                    continue;
                } else {
                    flipCount++;
                }
            } else {
                oneCount++;
            }
            if (flipCount > oneCount) {
                flipCount = oneCount;
            }
        }

        return flipCount;
    }
}
