/*
Problem:
You are playing a game with integers. You start with the integer 1 and you want to reach the integer target.

In one move, you can either:

Increment the current integer by one (i.e., x = x + 1).
Double the current integer (i.e., x = 2 * x).
You can use the increment operation any number of times, however, you can only use the double operation at 
most maxDoubles times.

Given the two integers target and maxDoubles, return the minimum number of moves needed to reach target 
starting with 1.

Link: https://leetcode.com/problems/minimum-moves-to-reach-target-score/

Solution:
Intuition: Move from target to 1 instead of 1 to target. This is important. Because when you do this, 
you will immediately see that if the number is even, it's better to divide by 2. And if its odd, anyway, 
it cannot be divided by 2 and we can just reduce it by 1.
*/

public class MinimumMovesToReachTargetScore {
    public int minMoves(int target, int maxDoubles) {
        int count = 0;
        while (target > 1 && maxDoubles > 0) {
            count++;
            if (target % 2 == 0)
                maxDoubles--;
            target = target % 2 == 0 ? target / 2 : target - 1;
        }
        return target > 0 ? count + target - 1 : count;
    }
}