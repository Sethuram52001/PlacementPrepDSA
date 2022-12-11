/*
Problem:
You are given an integer array nums. A subsequence of nums is called a square streak if:

The length of the subsequence is at least 2, and
after sorting the subsequence, each element (except the first element) is the square of the previous number.
Return the length of the longest square streak in nums, or return -1 if there is no square streak.

A subsequence is an array that can be derived from another array by deleting some or no elements without 
changing the order of the remaining elements.

Link: https://leetcode.com/problems/longest-square-streak-in-an-array/description/

Solution:
* If we find sqaure streaks from the lowest numbers, we don't have to compute the same process once again for the 
larger numbers which are the squares of smaller numbers. So, we can remove the numbers from the list of a particular 
streak has been computed.

* We can use a set to maintain a sorted list.

References:
i. My solution using treeset: https://leetcode.com/problems/longest-square-streak-in-an-array/solutions/2900321/simple-java-solution-using-treeset/?orderBy=most_votes
ii. Approach using DP: https://leetcode.com/problems/longest-square-streak-in-an-array/solutions/2899678/short-dp-c-java-lis-type/?orderBy=most_votes
*/

import java.util.*;

public class LongestSquareStreakInAnArray {
    public int longestSquareStreak(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longestStreak = 1;
        while (!set.isEmpty()) {
            int num = set.first();
            int streak = 0;
            while (!set.isEmpty() && set.contains(num)) {
                set.remove(num);
                num = num * num;
                streak++;
            }

            longestStreak = Math.max(streak, longestStreak);
        }

        return longestStreak == 1 ? -1 : longestStreak;
    }
    
    public int longestSquareStreak_DP(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        int longestStreak = 0;

        for(Integer num : nums) {
            int sqrt = (int)Math.sqrt(num);
            if(sqrt*sqrt == num) {
                dp.put(num, dp.getOrDefault(sqrt, 0) + 1);
            } else {
                dp.put(num, 1);
            }

            longestStreak = Math.max(longestStreak, dp.get(num));
        }

        return longestStreak == 1 ? -1 : longestStreak;
    }
}
