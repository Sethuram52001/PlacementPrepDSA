/*
Problem:
Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. 
The array is sorted in non-decreasing order, and there is only one way to form the array.

You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where 
you have to find the product of all powers[j] with lefti <= j <= righti.

Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith 
query may be too large, each answers[i] should be returned modulo 109 + 7.

Link: https://leetcode.com/problems/range-product-queries-of-powers/

Solution:
We can convert number to binary string, so that we can easily find the minimum
number of powers's of 2 required to form the given number.
Next we, can form a prefix sum (since multiplication, is just addition of powers of 2), then we can
perform the computation required based on the queries.
*/

import java.util.*;

public class RangeProductQueriesOfPowers {
    public int[] productQueries(int n, int[][] queries) {
        String binNum = Integer.toBinaryString(n);
        List<Integer> powers = new ArrayList<>();
        int power = 0;

        for (int idx = binNum.length() - 1; idx >= 0; idx--) {
            if (binNum.charAt(idx) == '1') {
                powers.add(power);
            }
            power += 1;
        }

        int[] powerSum = new int[powers.size() + 1];
        for (int idx = 1; idx < powerSum.length; idx++) {
            powerSum[idx] += powerSum[idx - 1] + powers.get(idx - 1);
        }

        int mod = (int) Math.pow(10, 9) + 7;
        int[] res = new int[queries.length];
        int idx = 0;
        for (int[] query : queries) {
            int a = query[0], b = query[1];
            res[idx++] = (int) (Math.pow(2, powerSum[b + 1] - powerSum[a]) % mod);
        }

        return res;
    }
}