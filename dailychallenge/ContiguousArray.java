/*
Problem:
Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

Link: https://leetcode.com/problems/contiguous-array/

Solution:
We can have count variable, we can increment it whenever 1 is seen and decrement whenever 0 is seen.
If the count value is repeated then we can say that the number of 1's and 0's in that span are equal.
For tracking the indices with corresponding count values we can use hashing.
*/

import java.util.*;

public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0, maxLen = 0, n = nums.length;
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            count = nums[i] == 0 ? count - 1 : count + 1;
            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return maxLen;
    }
}
