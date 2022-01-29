/*
Problem:
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
return the area of the largest rectangle in the histogram.

Link: https://leetcode.com/problems/largest-rectangle-in-histogram/

Solution:
We can find the left limit and right limit similar to next greater element concept.
*/

import java.util.*;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] leftLimit = new int[n];
        int[] rightLimit = new int[n];
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            
            if(st.isEmpty()) {
                leftLimit[i] = 0;
            }
            
            else {
                leftLimit[i] = st.peek() + 1;
            }
            
            st.push(i);
        }
        
        st.clear();
        
        for(int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && heights[i] <= heights[st.peek()]) {
                st.pop();
            }
            
            if(st.isEmpty()) {
                rightLimit[i] = n - 1;
            }
            
            else {
                rightLimit[i] = st.peek() - 1;
            }
            
            st.push(i);
        }
        
        //System.out.println(Arrays.toString(leftLimit));
        //System.out.println(Arrays.toString(rightLimit));
        
        int maxArea = 0;
        for(int i = 0; i < n; i++) {
            int area = (rightLimit[i] - leftLimit[i] + 1)*heights[i];
            maxArea = Math.max(maxArea, area);
        }
        
        return maxArea;
    }    
}
