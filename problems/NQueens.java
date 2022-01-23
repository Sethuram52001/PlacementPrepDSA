/*
Problem:
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.

Link: https://leetcode.com/problems/n-queens/

Solution: 
Backtracking
*/

import java.util.*;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> placements = new ArrayList<>();
        char[][] chessBoard = new char[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                chessBoard[i][j] = '.';
            }
        }

        backtrack(chessBoard, 0, placements);
        return placements;
    }

    private void backtrack(char[][] chessBoard, int row, List<List<String>> placements) {
        if (row == chessBoard.length) {
            // add placement
            List<String> placement = construct(chessBoard);
            placements.add(new ArrayList<>(placement));
            return;
        }

        for (int col = 0; col < chessBoard.length; col++) {
            if (isValid(chessBoard, row, col)) {
                chessBoard[row][col] = 'Q';
                backtrack(chessBoard, row + 1, placements);
                chessBoard[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] chessBoard) {
        List<String> placement = new ArrayList<>();
        for (char[] row : chessBoard) {
            placement.add(new String(row));
        }
        return placement;
    }

    private boolean isValid(char[][] chessBoard, int row, int col) {
        int r = row, c = col;

        // checking hor left
        while (r >= 0) {
            if (chessBoard[r][col] == 'Q') {
                return false;
            }
            r--;
        }

        r = row;
        // checking hor right
        while (r < chessBoard.length) {
            if (chessBoard[r][col] == 'Q') {
                return false;
            }
            r++;
        }

        // checking ver up
        while (c >= 0) {
            if (chessBoard[row][c] == 'Q') {
                return false;
            }
            c--;
        }

        c = col;
        //checking ver down
        while (c < chessBoard[0].length) {
            if (chessBoard[row][c] == 'Q') {
                return false;
            }
            c++;
        }

        // checking left diagonal
        r = row;
        c = col;
        while (r >= 0 && c >= 0) {
            if (chessBoard[r][c] == 'Q') {
                return false;
            }
            r--;
            c--;
        }

        // checking left diagonal
        r = row;
        c = col;
        while (r < chessBoard.length && c < chessBoard.length) {
            if (chessBoard[r][c] == 'Q') {
                return false;
            }
            r++;
            c++;
        }

        // checking right diagonal
        r = row;
        c = col;
        while (r >= 0 && c < chessBoard[0].length) {
            if (chessBoard[r][c] == 'Q') {
                return false;
            }
            r--;
            c++;
        }

        // checking right diagonal
        r = row;
        c = col;
        while (r < chessBoard.length && c >= 0) {
            if (chessBoard[r][c] == 'Q') {
                return false;
            }
            r++;
            c--;
        }

        return true;
    }
}