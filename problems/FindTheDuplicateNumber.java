/*
Problem:
Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

There is only one repeated number in nums, return this repeated number.

You must solve the problem without modifying the array nums and uses only constant extra space.

Link: https://leetcode.com/problems/find-the-duplicate-number/

Solution:
We can the treat the array as a linked list and use the floyd and tortoise cycle detection method to 
find the duplicate.

Proof for Floyd Detection method:
Let the fast pointer mover 2a and slow pointer distance of a.
a = n*C ( c- lenght of cycle, n is multiple)
let x be the distance between first and duplicate node
and a - x will be the distance between meeting point and duplicate node
Now a- x +x = a, so they're bound to meet
video: https://www.youtube.com/watch?v=32Ll35mhWg0&list=PLgUwDviBIf0rPG3Ictpu74YWBQ1CaBkm2&index=2

*/

public class FindTheDuplicateNumber {
    private static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);
        
        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return fast;
    }
    public static void main(String[] args) {
        int[] nums = new int[] { 3, 1, 3, 4, 2 };
        int dup = findDuplicate(nums);
        System.out.println("duplicate: " + dup);
    }
}
