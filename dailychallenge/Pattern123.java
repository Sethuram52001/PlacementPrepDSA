/*
Problem:
Given an array of n integers nums, a 132 pattern is a subsequence of three integers nums[i], nums[j] 
and nums[k] such that i < j < k and nums[i] < nums[k] < nums[j].

Return true if there is a 132 pattern in nums, otherwise, return false.

Link: https://leetcode.com/problems/132-pattern/

Solution:
Here, if we fix the peak, i.e. 3 in the 132 pattern, then we can determine if any numbers on its left 
and right satisfy the given pattern. We will do this with the help of a stack. Our stack implementation
will take care of the 32 pattern and then we will iterate over the array to find if any number satisfies 
the 1 pattern.

Reference: https://leetcode.com/problems/132-pattern/discuss/906789/Short-Java-O(N)-Solution-with-Detailed-Explanation-and-Sample-Test-Case-or-Stack-or-100
*/

import java.util.*;

public class Pattern123 {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < second) {
                return true;
            }

            while (!st.isEmpty() && nums[i] > st.peek()) {
                second = st.pop();
            }

            st.push(nums[i]);
        }

        return false;
    }
}