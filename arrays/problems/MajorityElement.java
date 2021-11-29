package problems;

/*
 Problem:
 Given an array nums of size n, return the majority element.
 The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume 
 that the majority element always exists in the array.

 Link: https://leetcode.com/problems/majority-element/

 Solution: 
 Moore-Voting algo
*/

public class MajorityElement {
    private static int majorityElement(int[] nums) {
        int candidate = 0, count = 0;
        for(int i : nums) {
            if(count == 0) {
                candidate = i;
            }
            
            count += (candidate == i) ? 1 : -1;
        }
        return candidate;
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 2, 2, 1, 1, 1, 2, 2 };
        int majorityElement = majorityElement(nums);
        System.out.println(majorityElement);
    }
}
