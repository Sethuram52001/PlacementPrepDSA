/*
Problem:
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Link: https://leetcode.com/problems/sudoku-solver/

Solution: 
We can use a backtracking approach to solve it.
We can frame a relation to check the validity in 3x3 grid:
minR = 3 * (row / 3) + i / 3;
minC = 3 * (col / 3) + i % 3;
*/

public class SudokuSolver {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    for (char digit = '1'; digit <= '9'; digit++) {
                        if (isValid(board, r, c, digit)) {
                            board[r][c] = digit;

                            if (backtrack(board)) {
                                return true;
                            } else {
                                board[r][c] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char digit) {
        for (int i = 0; i < 9; i++) {
            if (board[i][col] != '.' && board[i][col] == digit) {
                return false;
            }

            if (board[row][i] != '.' && board[row][i] == digit) {
                return false;
            }

            int minR = 3 * (row / 3) + i / 3;
            int minC = 3 * (col / 3) + i % 3;
            if (board[minR][minC] != '.' && board[minR][minC] == digit) {
                return false;
            }
        }
        return true;
    }
}