/*
Problem:
Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
Note:

A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Link: https://leetcode.com/problems/valid-sudoku/

Solution:
We can maintain hashset to maintain uniqueness
For the 3*3 min grid we can use this relation:
3*(row/3) + (col/3)
*/

import java.util.*;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] row = new HashSet[9];
        HashSet<Character>[] col = new HashSet[9];
        HashSet<Character>[] minSq = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            row[i] = new HashSet<>();
            col[i] = new HashSet<>();
            minSq[i] = new HashSet<>();
        }

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                /*System.out.print("r: " + r + " c: " + c + " ");
                int minPos = 3*(r/3) + c/3;
                System.out.println(" minPos: " + minPos);*/
                if (board[r][c] == '.') {
                    continue;
                } else {
                    char val = board[r][c];
                    int minPos = 3 * (r / 3) + c / 3;
                    if (row[r].contains(val) || col[c].contains(val) || minSq[minPos].contains(val)) {
                        return false;
                    } else {
                        row[r].add(val);
                        col[c].add(val);
                        minSq[minPos].add(val);
                    }
                }
            }
        }
        return true;
    }
}