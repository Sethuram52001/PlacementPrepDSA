/*
Problem:
Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from 
three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0. 

Link: https://leetcode.com/problems/largest-perimeter-triangle/

Solution:
Without loss of generality, say the sidelengths of the triangle are a <= b= <= c. The necessary and sufficient 
condition for these lengths to form a triangle of non-zero area is a + b > c.

Say we knew cc already. There is no reason not to choose the largest possible aa and bb from the array. If a + b > c, 
then it forms a triangle, otherwise it doesn't.
*/

import java.util.*;

public class LargestPerimeterTriangle {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int k = nums.length - 1; k >= 2; k--) {
            int sum = nums[k - 1] + nums[k - 2];
            if(sum > nums[k]) {
                return sum + nums[k];
            }
        }
        
        return 0;
    }    
}
