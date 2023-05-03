
/*
Problem:
Given two 0-indexed integer arrays nums1 and nums2, return a list answer of size 2 where:

answer[0] is a list of all distinct integers in nums1 which are not present in nums2.
answer[1] is a list of all distinct integers in nums2 which are not present in nums1.
Note that the integers in the lists may be returned in any order.

Link: https://leetcode.com/problems/find-the-difference-of-two-arrays/description/

Solution:
Use hashsets to keep unique elements present in nums1 and nums2.
*/

import java.util.*;

public class FindTheDifferenceOfTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums2Set = new HashSet<>();
        for(int num : nums2) {
            nums2Set.add(num);
        }

        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> elementsToRemoveInNums2 = new HashSet<>();
        for(int num : nums1) {
            if(nums2Set.contains(num)) {
                elementsToRemoveInNums2.add(num);
            } else {
                nums1Set.add(num);
            }
        }
        for(int num : elementsToRemoveInNums2) {
            nums2Set.remove(num);
        }

        return Arrays.asList(new ArrayList<>(nums1Set), new ArrayList<>(nums2Set));
    }    
}
