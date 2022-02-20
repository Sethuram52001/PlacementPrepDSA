/*
Problem:
Given an array of integers arr of even length n and an integer k.

We want to divide the array into exactly n / 2 pairs such that the sum of each pair is divisible by k.

Return true If you can find a way to do that or false otherwise.

Link: https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/

Solution:
Remainder theorem can be used to solve this problem the freq of x(i.e., x = num % k) must be equal to freq of k - x. Specical case of mod == 0 can 
be handled by checking for even parity.

Negative numbers:
if a number is negative for example:
-1 % 3 = -1
but the -1 must be a positive remainder for that, we can frame a condition:
if (rem < 0) rem += k
*/

public class CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        int[] modFreq = new int[k];
        for(int num : arr) {
            num %= k;
            if(num < 0) {
                num += k;
            }
            modFreq[num]++;
        }
        
        for(int i = 1; i <= k/2; i++) {
            if(modFreq[i] != modFreq[k - i]) {
                return false;
            }
        }
        return modFreq[0] % 2 == 0;
    }   
}