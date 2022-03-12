/*
Problem:
Given an integer array nums, return an array answer such that answer[i] is equal to the product of all 
the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.

Link: https://leetcode.com/problems/product-of-array-except-self/

Solution:
prefix and postfix array of products
*/

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf_ConstantSpace(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        res[0] = 1;
        for (int i = 1; i < n; i++) {
            res[i] = nums[i - 1] * res[i - 1];
        }

        int postProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            res[i] *= postProduct;
            postProduct *= nums[i];
        }

        return res;
    }
    
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        
        pre[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1]*nums[i - 1];
        }
        
        post[n - 1] = 1;
        for(int i =  n - 2; i >= 0; i--) {
            post[i] = post[i + 1]*nums[i + 1];
        }
        
        int[] res = new int[n];
        for(int i = 0; i < n; i++) {
            res[i] = pre[i]*post[i];
        }
        
        return res;
    }   
}