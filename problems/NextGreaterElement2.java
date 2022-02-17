/*
Problem:
Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element 
in nums.

The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly
to find its next greater number. If it doesn't exist, return -1 for this number.

Link: https://leetcode.com/problems/next-greater-element-ii/

Solution:
We can use the same approach as the next-greater-element-1 with stack.
But to treat the array as a circular array, we can use a simple track of traversing the array twice like shown below:
1   2   3   4   3 | 1   2   3   4   3
*/

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int[] nge = new int[n];
        Arrays.fill(nge, -1);
        
        for(int i = 0; i < 2*n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i % n]) {
                nge[st.pop()] = nums[i % n];
            }
            if(i < n) {
                st.push(i);
            }
        }
        return nge;
    }
}