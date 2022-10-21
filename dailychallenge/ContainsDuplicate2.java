/*
Problem:
Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array 
such that nums[i] == nums[j] and abs(i - j) <= k.

Link: https://leetcode.com/problems/contains-duplicate-ii/

Solution:
Maintain a set or map to keep track of duplicates.
*/

import java.util.*;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int idx = 0; idx < nums.length; idx++) {
            if(idx > k) {
                set.remove(nums[idx - k - 1]);
            }
            
            if(set.contains(nums[idx])) {
                return true;
            } else {
                set.add(nums[idx]);
            }
        }
        
        return false;
    }
}
