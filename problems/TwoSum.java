import java.util.Arrays;
import java.util.HashMap;

/*
 Problem:
 Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 You can return the answer in any order.

 Link: https://leetcode.com/problems/two-sum/

 Solution:
 hash table
*/

public class TwoSum {
    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (h.containsKey(rem)) {
                return new int[] { h.get(rem), i };
            } else {
                h.put(nums[i], i);
            }
        }
        return new int[] { -1, -1 };
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 7, 11, 15 };
        int target = 9;
        int[] pair = twoSum(nums, target);
        System.out.println(Arrays.toString(pair));
    }
}
