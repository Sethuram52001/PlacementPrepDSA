/*
Problem:
There is a new barn with N stalls and C cows. The stalls are located on a straight line at positions x1,….,xN 
(0 <= xi <= 1,000,000,000). We want to assign the cows to the stalls, such that the minimum distance between any 
two of them is as large as possible. What is the largest minimum distance?

Link: https://www.codingninjas.com/codestudio/problems/chess-tournament_981299?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website

Solution:
We can do binary search on the search space, and check for the validity
*/

import java.util.*;

public class AggressiveCows {
    private static boolean isPossible(int[] positions, int n, int c, int distance) {
        int lastPlaced = positions[0];
        c -= 1;
        for (int i = 1; i < n; i++) {
            if (positions[i] - lastPlaced >= distance) {
                c--;
                lastPlaced = positions[i];
            }
        }
        return c <= 0;
    }

    public static int chessTournament(int[] positions, int n, int c) {
        // Write your code here.    
        Arrays.sort(positions);
        int low = 1;
        int high = positions[n - 1] - positions[0];

        int res = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(positions, n, c, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}