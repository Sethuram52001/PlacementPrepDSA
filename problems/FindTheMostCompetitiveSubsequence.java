/*
Problem:
Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.

An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first 
position where a and b differ, subsequence a has a number less than the corresponding number in b. For example, 
[1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 
is less than 5.

Link: https://leetcode.com/problems/find-the-most-competitive-subsequence/

Solutin:
We can maintain monotonically increasing stack of the numbers array, now we can just get the last k 
elements of the stack, which is the most competitive sequence in the array.

Reference: 1. https://leetcode.com/problems/find-the-most-competitive-subsequence/discuss/952786/JavaC%2B%2BPython-One-Pass-Stack-Solution
*/

import java.util.*;

public class FindTheMostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (st.isEmpty()) {
                st.push(i);
            }
            // if nums[i] < top of the stack
            else if (nums[i] < nums[st.peek()] && nums.length - i + st.size() > k) {
                while (!st.isEmpty() && nums[i] < nums[st.peek()] && nums.length - i + st.size() > k) {
                    st.pop();
                }
                st.push(i);
            } else {
                st.push(i);
            }
            //System.out.println("i: " + i + " => " + st.toString());
        }

        int[] ans = new int[k];
        int idx = 0;
        while (idx < k) {
            ans[idx++] = nums[st.removeLast()];
        }

        return ans;
    }
}