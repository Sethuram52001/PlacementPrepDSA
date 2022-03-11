/*
Problem:
You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) 
and (i, height[i]).

Find two lines that together with the x-axis form a container, such that the container contains the most water.

Return the maximum amount of water a container can store.

Notice that you may not slant the container.

Link: https://leetcode.com/problems/container-with-most-water/

Solution:
2 pointers
*/

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = -1;
        
        while(left < right) {
            int area = Math.min(height[left], height[right])*(right - left);
            maxArea = Math.max(area, maxArea);
            
            if(height[left] > height[right]) {
                right--;
            }
            else {
                left++;
            }
        }
        
        return maxArea;
    }
}