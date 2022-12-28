/*
Problem:
You are given a 0-indexed integer array piles, where piles[i] represents the number of stones in the ith pile, 
and an integer k. You should apply the following operation exactly k times:

Choose any piles[i] and remove floor(piles[i] / 2) stones from it.
Notice that you can apply the operation on the same pile more than once.

Return the minimum possible total number of stones remaining after applying the k operations.

floor(x) is the greatest integer that is smaller than or equal to x (i.e., rounds x down).

Link: https://leetcode.com/problems/remove-stones-to-minimize-the-total/description/

Solution:
Greedy approach - use a heap to keep track of the maximum pile at each time.
*/
import java.util.PriorityQueue;

public class RemoveStonesToMinimizeTheTotal {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int stoneSum = 0;
        for (int pile : piles) {
            pq.add(pile);
            stoneSum += pile;
        }

        while (k-- > 0) {
            int pile = pq.remove();
            if (pile <= 1) {
                return stoneSum;
            }

            int removePile = (int) Math.floor(pile / 2);
            pile -= removePile;
            stoneSum -= removePile;
            pq.add(pile);
        }

        return stoneSum;
    }
}
