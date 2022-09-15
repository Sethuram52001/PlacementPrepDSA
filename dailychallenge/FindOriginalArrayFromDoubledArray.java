/*
Problem:
An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.

Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.

Link: https://leetcode.com/problems/find-original-array-from-doubled-array/

Solution:
Let's see a simple case
Assume all interger are positive, for example [2,4,4,8].
We have one x = 2, we need to match it with one 2x = 4.
Then one 4 is gone, we have the other x = 4.
We need to match it with one 2x = 8.
Finaly no number left.

Why we start from 2?
Because it's the smallest and we no there is no x/2 left.
So we know we need to find 2x

Explanation
Count all numbers.
Loop all numbers on the order of its absolute.
We have counter[x] of x, so we need the same amount of 2x wo match them.
If c[x] > c[2 * x], then we return []
If c[x] <= c[2 * x], then we repeatly do c[2 * x]-- and append x to result res
Don't worry about 0, it doesn't fit the logic above but it won't break our algorithme.

In case count[0] is odd, it won't get matched in the end.

In case count[0] is even, we still have c[0] <= c[2 * 0].
And we still need to check all other numbers.

Reference: https://leetcode.com/problems/find-original-array-from-doubled-array/discuss/1470959/JavaC%2B%2BPython-Match-from-the-Smallest-or-Biggest-100
*/

public class FindOriginalArrayFromDoubledArray {
    public int[] findOriginalArray(int[] changed) {
        if (changed.length % 2 == 1) {
            return new int[0];
        }
        Map<Integer, Integer> freqMap = new TreeMap<>();
        int[] original = new int[changed.length / 2];
        for (int val : changed) {
            freqMap.put(val, freqMap.getOrDefault(val, 0) + 1);
        }

        int idx = 0;
        for (Integer key : freqMap.keySet()) {
            if (freqMap.get(key) > freqMap.getOrDefault(key * 2, 0)) {
                return new int[0];
            }

            for (int i = 0; i < freqMap.get(key); i++) {
                original[idx++] = key;
                freqMap.put(key * 2, freqMap.get(key * 2) - 1);
            }
        }

        return original;
    }
}
