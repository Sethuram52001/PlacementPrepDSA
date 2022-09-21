/*
Problem:
You are given an integer array nums and an array queries where queries[i] = [vali, indexi].

For each query i, first, apply nums[indexi] = nums[indexi] + vali, then print the sum of the even values of nums.

Return an integer array answer where answer[i] is the answer to the ith query.

Link: https://leetcode.com/problems/sum-of-even-numbers-after-queries/

Solution:
Maintain a sum of even numbers in the array, and constantly update the sum 
upon each query.
*/

public class SumOfEvenNumbersAfterQueries {
        public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int evenSum = 0;
        for(int idx = 0; idx < nums.length; idx++) {
            if(nums[idx] % 2 == 0) {
                evenSum += nums[idx];
            }
        }
        
        int[] res = new int[queries.length];
        int k = 0;
        
        for(int[] query : queries) {
            int idx = query[1];
            int val = query[0];
            if(nums[idx] % 2 == 0) {
                evenSum -= nums[idx];
            }
            
            nums[idx] += val;
            if(nums[idx] % 2 == 0) {
                evenSum += nums[idx];
            }
            
            res[k++] = evenSum;
        }
        
        return res;
    }
}