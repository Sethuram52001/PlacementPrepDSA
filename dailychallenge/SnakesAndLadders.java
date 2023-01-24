/*
Problem:
You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style 
starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

You start on square 1 of the board. In each move, starting from square curr, do the following:

Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, 
regardless of the size of the board.
If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
The game ends when you reach the square n2.
A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or 
ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the 
start of another snake or ladder, you do not follow the subsequent snake or ladder.

For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You 
follow the ladder to square 3, but do not follow the subsequent ladder to 4.
Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.

Link: https://leetcode.com/problems/snakes-and-ladders/description/

Solution:
BFS
*/

import java.util.*;

public class SnakesAndLadders {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            int pos = queue.poll();
            if (pos == n * n) {
                return map.get(pos);
            }

            for (int i = pos + 1; i <= Math.min(pos + 6, n * n); i++) {
                int next = check(i, n);
                int row = next / n, col = next % n;
                int ns = board[row][col] == -1 ? i : board[row][col];
                if (!map.containsKey(ns)) {
                    map.put(ns, map.get(pos) + 1);
                    queue.offer(ns);
                }
            }
        }

        return -1;
    }

    private int check(int i, int n) {
        int oldRow = (i - 1) / n, oldCol = (i - 1) % n;
        int row = n - 1 - oldRow;
        int col = row % 2 != n % 2 ? oldCol : n - 1 - oldCol;
        return row * n + col;
    }
}
