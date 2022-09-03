
/*
Problem:
Return all non-negative integers of length n such that the absolute difference between every two consecutive digits is k.

Note that every number in the answer must not have leading zeros. For example, 01 has one leading zero and is invalid.

You may return the answer in any order.

Link: https://leetcode.com/problems/numbers-with-same-consecutive-differences/

Solution:
Explanation
We initial the current result with all 1-digit numbers,
like cur = [1, 2, 3, 4, 5, 6, 7, 8, 9].

Each turn, for each x in cur,
we get its last digit y = x % 10.
If y + K < 10, we add x * 10 + y + K to the new list.
If y - K >= 0, we add x * 10 + y - K to the new list.

We repeat this step N - 1 times and return the final result.


Complexity
If K >= 5, time and Space O(N)
If K <= 4, time and space O(2^N)

Reference: https://leetcode.com/problems/numbers-with-same-consecutive-differences/discuss/211183/JavaC%2B%2BPython-Iterative-BFS-Solution
*/
import java.util.*;

public class NumbersWithSameConsecutiveDifferences {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> currNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        for (int i = 2; i <= n; i++) {
            List<Integer> nextNumbers = new ArrayList<>();
            for (Integer num : currNumbers) {
                int lastDigit = num % 10;
                if (lastDigit + k < 10) {
                    nextNumbers.add(num * 10 + lastDigit + k);
                }
                if (k > 0 && lastDigit - k >= 0) {
                    nextNumbers.add(num * 10 + lastDigit - k);
                }
            }
            currNumbers = nextNumbers;
        }

        return currNumbers.stream().mapToInt(i -> i).toArray();
    }
}