package problems;

import java.util.*;

/*
 Problem:
    Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    i. 0 <= a, b, c, d < n
    ii. a, b, c, and d are distinct.
    iii. nums[a] + nums[b] + nums[c] + nums[d] == target

    You may return the answer in any order.
 
 Link: https://leetcode.com/problems/4sum/

 Solution:
 first sort the array
 now use 2 for loops fix 1st and 2nd number of the quad pair
 now use 2 pointer approach to find the 3rd and 4th number of the quad pair
 
*/

public class FourSum {
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            for (int j = i + 1; j < nums.length - 2; j++) {
                int rem = nums[i] + nums[j];
                int l = j + 1, r = nums.length - 1;

                while (l < r) {
                    if ((rem + nums[l] + nums[r]) == target) {
                        List<Integer> quadPair = new ArrayList<>();
                        quadPair.add(nums[i]);
                        quadPair.add(nums[j]);
                        quadPair.add(nums[l]);
                        quadPair.add(nums[r]);
                        res.add(quadPair);

                        // skipping 3rd number if it's duplicate
                        while (l < r && nums[l] == quadPair.get(2)) {
                            l++;
                        }

                        //skipping 4th number if it's duplicate
                        while (l < r && nums[r] == quadPair.get(3)) {
                            r--;
                        }
                    } else if ((rem + nums[l] + nums[r]) < target) {
                        l++;
                    } else {
                        r--;
                    }
                }

                // skipping 2nd number if it's duplicate
                while (j + 1 < nums.length && nums[j + 1] == nums[j]) {
                    j++;
                }
            }
            // skipping 2nd number if it's duplicate
            while (i + 1 < nums.length && nums[i + 1] == nums[i]) {
                i++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        List<List<Integer>> res = fourSum(nums, target);

        for (List<Integer> quadPair : res) {
            System.out.println(quadPair.toString());
        }
    }
}
