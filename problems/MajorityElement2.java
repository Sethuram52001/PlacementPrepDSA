import java.util.*;

/*
 Problem:
 Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 Link: https://leetcode.com/problems/majority-element-ii/

 Solution:
 The idea is the based on moore's voting algorithm and here we can have 2 candidates because atmost there can be only 2 elements
 with freq more than n/3
*/

public class MajorityElement2 {
    private static List<Integer> majorityElement(int[] nums) {
        HashSet<Integer> majority = new HashSet<>();
        int candidate1 = -1, candidate2 = -1;
        int count1 = 0, count2 = 0;

        for (int i : nums) {
            if (candidate1 == i) {
                count1++;
            } else if (candidate2 == i) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = i;
                count1 = 1;
            } else if (count2 == 0) {
                count2 = 1;
                candidate2 = i;
            } else {
                count1--;
                count2--;
            }
        }

        // checking if it's actually majority element
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (candidate1 == i) {
                count1++;
            }
            if (candidate2 == i) {
                count2++;
            }
        }

        if (count1 > nums.length / 3) {
            majority.add(candidate1);
        }
        if (count2 > nums.length / 3) {
            majority.add(candidate2);
        }

        return new ArrayList<>(majority);
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 2, 3 };
        List<Integer> major = majorityElement(nums);
        System.out.println(major.toString());
    }
}
