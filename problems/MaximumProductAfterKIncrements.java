/*
Problem:
You are given an array of non-negative integers nums and an integer k. In one operation, you may choose any 
element from nums and increment it by 1.

Return the maximum product of nums after at most k operations. Since the answer may be very large, return it 
modulo 10^9 + 7.

Link: https://leetcode.com/problems/maximum-product-after-k-increments/

Solution:
Product of the array will be maximum when the smallest number in the array is maximum.
We use priority queue to find the smallest element in every iteration and increase it by 1.
*/

public class MaximumProductAfterKIncrements {
    long mod = (int) Math.pow(10, 9) + 7;

    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
        }

        while (k > 0) {
            int val = minHeap.remove();
            minHeap.add(val + 1);
            k--;
        }

        long ans = 1;
        while (!minHeap.isEmpty()) {
            int val = minHeap.remove();
            ans = ((ans % mod) * (val % mod)) % mod;
        }

        return (int) ans;
    }
}