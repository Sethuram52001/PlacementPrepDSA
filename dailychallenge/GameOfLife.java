/*
Problem:
The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

1. Any live cell with fewer than two live neighbors dies as if caused by under-population.
2. Any live cell with two or three live neighbors lives on to the next generation.
3. Any live cell with more than three live neighbors dies, as if by over-population.
4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.

Link: https://leetcode.com/problems/game-of-life/

Solution:
1. First create a temporary matrix. We will update all the values to this matrix.
1. Just loop through the matrix; at each cell, add sum of all the 8 neighbours (consider out of bound cells as 0). used "liveNeighbors" variable for this.  
2. Then using the rules given in question, update the temporary matrix cells.
3. After the loop, copy all the temporary matrix values to original matrix "board".
*/

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int n = board.length, m = board[0].length;
        int[][] tempBoard = new int[n][m];

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                int liveNeighbours = neighbour(board, r - 1, c - 1) + neighbour(board, r - 1, c)
                        + neighbour(board, r, c - 1) + neighbour(board, r + 1, c - 1) + neighbour(board, r - 1, c + 1)
                        + neighbour(board, r + 1, c + 1) + neighbour(board, r + 1, c) + neighbour(board, r, c + 1);
                if (board[r][c] == 1) {
                    tempBoard[r][c] = (liveNeighbours < 2 || liveNeighbours > 3) ? 0 : 1;
                } else {
                    tempBoard[r][c] = (liveNeighbours == 3) ? 1 : 0;
                }
            }
        }

        for (int r = 0; r < n; r++) {
            board[r] = tempBoard[r].clone();
        }
    }

    private int neighbour(int[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 0) {
            return 0;
        }
        return 1;
    }
}