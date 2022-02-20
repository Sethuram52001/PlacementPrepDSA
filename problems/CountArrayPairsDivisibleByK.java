/*
Problem:
Given a 0-indexed integer array nums of length n and an integer k, return the number of pairs (i, j) such that:
* 0 <= i < j <= n - 1 and
* nums[i] * nums[j] is divisible by k.

Link: https://leetcode.com/problems/count-array-pairs-divisible-by-k/

Solution:
For a given number, only the gcd between current number num[i] and k need to be considered. All we need to do is to count/group the numbers by 
the gcds. And if gcd(num[i], k) * gcd(num[j], k) is divisible by k , num[i] * num[j] should also be divisible.

Intuition
A number with a factor i will form a pair with a number with a factor j if i * j is divisible by k.
It can be shown that if n1 * n2 % k == 0, then gcd(n1, k) * gcd(n2, k) % k == 0.

Count all elements greatest common divisor with k.
For each pair (a, b) of divisors, check if a * b % k == 0
*/

public class CountArrayPairsDivisibleByK {
    public long countPairs(int[] nums, int k) {
        long pairs = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int gcd = gcd(nums[i], k);
            for(int num : map.keySet()) {
                if((long)gcd*num%k == 0) {
                    pairs += map.get(num);
                }
            }
            map.put(gcd, map.getOrDefault(gcd, 0) + 1);
        }
        return pairs;
    }
    
    private int gcd(int x, int y) {
        if(x < y) {
            return gcd(y, x);
        }
        return y == 0 ? x : gcd(y, x % y);
    }
}
