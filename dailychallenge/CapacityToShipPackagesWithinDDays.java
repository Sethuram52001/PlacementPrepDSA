/*
Problem:
A conveyor belt has packages that must be shipped from one port to another within days days.

The ith package on the conveyor belt has a weight of weights[i]. Each day, we load the ship 
with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the 
conveyor belt being shipped within days days.

Link: https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/

Solution: 
Given the number of bags,
return the minimum capacity of each bag,
so that we can put items one by one into all bags.

We binary search the final result.
The left bound is max(A),
The right bound is sum(A).
*/

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }

        while (left < right) {
            int mid = (left + right) / 2, need = 1, curr = 0;
            for (int w : weights) {
                if (curr + w > mid) {
                    need += 1;
                    curr = 0;
                }
                curr += w;
            }

            if (need > days) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
