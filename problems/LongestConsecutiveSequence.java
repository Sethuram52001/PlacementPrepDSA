import java.util.*;

/*
 Problem:
 Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 You must write an algorithm that runs in O(n) time.

 Link: https://leetcode.com/problems/longest-consecutive-sequence/

 Solution:
 We can use a hashset and check for availabilty of num - 1 element if itsn't present we start iterating for n increments on num
 till the num + 1 is present in the hashset
*/

public class LongestConsecutiveSequence {
    private static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int longestCon = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i] - 1)) {
                int currNum = nums[i];
                int curr = 1;

                while (set.contains(currNum + 1)) {
                    curr++;
                    currNum++;
                }

                longestCon = Math.max(longestCon, curr);
            }
        }

        return longestCon;
    }

    public static void main(String[] args) {
        int[] nums = new int[] { 100, 4, 200, 1, 3, 2 };
        System.out.println(longestConsecutive(nums));
    }
}
