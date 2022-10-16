/*
Problem:
You are given a 0-indexed array nums comprising of n non-negative integers.

In one operation, you must:

Choose an integer i such that 1 <= i < n and nums[i] > 0.
Decrease nums[i] by 1.
Increase nums[i - 1] by 1.
Return the minimum possible value of the maximum integer of nums after performing any number of operations.

Link: https://leetcode.com/problems/minimize-maximum-of-array/

Solution: 
In one operation: decrease A[i] by 1. increase A[i - 1] by 1.

We actully move the value of A[i] to A[i - 1] by 1, the sum won't change.

If A[i] < A[i + 1], then we can repeatly do the operations, until A[i] >= A[i+1].
So finally the array A will become decrescent order.

We calculate the prefix sum arrray and their average. The average is the lower bound of the result,
and it's reachable lower bound by the process in intuition, so this average is the result.We need to 
calculate the ceil integer of the average,

Reference: https://leetcode.com/problems/minimize-maximum-of-array/discuss/2706521/JavaC%2B%2BPython-Prefix-Sum-Average-O(n)
*/

public class MinimizeMaximumOfArray {
    public int minimizeArrayValue(int[] nums) {
        double sum = 0;
        int max = Integer.MIN_VALUE;
        for(int idx = 0; idx < nums.length; idx++) {
            sum += nums[idx];
            max = Math.max(max, (int)Math.ceil(sum /(idx + 1)));
        }
        
        return max;
    }
}
