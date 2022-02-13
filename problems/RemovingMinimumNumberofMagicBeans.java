/*
Problem:
You are given an array of positive integers beans, where each integer represents the number of magic beans found in a particular magic bag.
Remove any number of beans (possibly none) from each bag such that the number of beans in each remaining non-empty bag (still containing at
least one bean) is equal. Once a bean has been removed from a bag, you are not allowed to return it to any of the bags.
Return the minimum number of magic beans that you have to remove.

Link: https://leetcode.com/problems/removing-minimum-number-of-magic-beans/

Solution:
Sort the original array A.
If we select A[i] as the number of beans in a non-empty bag, the number of removals needed is sum(A) - (N - i) * A[i].
*/

import java.util.*;

public class RemovingMinimumNumberofMagicBeans {
    public long minimumRemoval(int[] beans) {
        Arrays.sort(beans);
        long max = Integer.MIN_VALUE, n = beans.length, sum = 0;
        
        for(int i = 0; i < n; i++) {
            sum += beans[i];
            max = Math.max(max, (n - i)*(long)beans[i]);
        }
        
        return sum - max;
    }
}