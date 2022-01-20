/*
Problem:
Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.
Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
Return the minimum integer k such that she can eat all the bananas within h hours.

Link: https://leetcode.com/problems/koko-eating-bananas/

Solution:
Binary search
*/

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = maxPile(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;
            int totalHours = 0;
            for (int pile : piles) {
                totalHours += Math.ceil((double) pile / mid);
                if (totalHours > h) {
                    break;
                }
            }

            if (totalHours > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int maxPile(int[] piles) {
        int max = Integer.MIN_VALUE;
        for (int pile : piles) {
            if (pile > max) {
                max = pile;
            }
        }
        return max;
    }
}