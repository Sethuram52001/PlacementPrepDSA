/*
Problem:
You have a set of integers s, which originally contains all the numbers from 1 to n. 
Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, 
which results in repetition of one number and loss of another number.
You are given an integer array nums representing the data status of this set after the error.
Find the number that occurs twice and the number that is missing and return them in the form of an array.

Link: https://leetcode.com/problems/set-mismatch/

Solution:
1. Find the missing number:
a. Replace every number you encounter by marking it in actual index(in ascending order), by using some flag.
b. Now, if you encounter that an index is already been flagged, then that is the duplicate number.

2. Missing number: expected sum - (actual sum - duplciate)
*/

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int actualSum = 0, duplicate = -1;
        for (int idx = 0; idx < nums.length; idx++) {
            int index = Math.abs(nums[idx]) - 1;
            if (nums[index] < 0) {
                duplicate = index + 1;
            } else {
                nums[index] = -nums[index];
            }
        }

        for (int num : nums) {
            actualSum += num < 0 ? -num : num;
        }

        int expectedSum = nums.length * (nums.length + 1) / 2;
        return new int[] { duplicate, expectedSum - (actualSum - duplicate) };
    }
}
