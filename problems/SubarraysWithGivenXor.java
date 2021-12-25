import java.util.HashMap;

/*
Problem:
Given an array of integers A and an integer B.
Find the total number of subarrays having bitwise XOR of all elements equals to B.

Link: https://www.interviewbit.com/problems/subarray-with-given-xor/

Solution:
Think of as an subarray problem
*/

public class SubarraysWithGivenXor {
    public int solve(int[] A, int B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0, xor = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            xor = xor ^ A[i];
            if (freq.containsKey(xor ^ B)) {
                count += freq.get(xor ^ B);
            }

            if (xor == B) {
                count++;
            }

            freq.put(xor, freq.getOrDefault(xor, 0) + 1);
        }

        return count;
    }
}
