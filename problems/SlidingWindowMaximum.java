/*
Problem:
You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. 
Each time the sliding window moves right by one position.

Return the max sliding window.

Link: https://leetcode.com/problems/sliding-window-maximum/

Solution:
We have to maintain a non-increasing order of elements(since we'll pop out the first element once we reach the window size).
For this we'll use a deque to perform operations on both end.
*/

public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] swm = new int[n - k + 1];
        int j = 0;
        
        for(int i = 0; i < n; i++) {
            if(!deque.isEmpty() && deque.peek() == i - k) {
                deque.pollFirst();
            }
            
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offer(i);
            
            if(i >= k - 1) {
                swm[j++] = nums[deque.peekFirst()];    
            }
        }
        
        return swm;
    }   
}