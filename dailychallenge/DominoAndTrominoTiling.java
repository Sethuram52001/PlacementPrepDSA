/*
Problem:
You have two types of tiles: a 2 x 1 domino shape and a tromino shape. You may rotate these shapes.
Given an integer n, return the number of ways to tile an 2 x n board. Since the answer may be very 
large, return it modulo 109 + 7.

In a tiling, every square must be covered by a tile. Two tilings are different if and only if there 
are two 4-directionally adjacent cells on the board such that exactly one of the tilings has both squares 
occupied by a tile.

Link: https://leetcode.com/problems/domino-and-tromino-tiling/description/

Solution:
DP:
Try to draw the combinations and frame the equations for dp states.

Reference: 
1. https://leetcode.com/problems/domino-and-tromino-tiling/solutions/116612/easy-to-understand-o-n-solution-with-drawing-picture-explanation/?orderBy=most_votes
*/

public class DominoAndTrominoTiling {
    public int numTilings(int n) {
        int mod = 1_000_000_007;
        long[] d = new long[1001], t = new long[1001];
        d[0] = 0;
        d[1] = 1;
        d[2] = 2;
        t[0] = 0;
        t[1] = 1;
        t[2] = 2;

        for (int i = 3; i <= n; i++) {
            t[i] = (t[i - 1] + d[i - 1]) % mod;
            d[i] = (d[i - 1] + d[i - 2] + 2 * t[i - 2]) % mod;
        }

        return (int) (d[n] % mod);
    }
}
