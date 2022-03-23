/*
Problem:
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally 
or vertically neighboring. The same letter cell may not be used more than once.

Link: https://leetcode.com/problems/word-search/

Solution:
DFS
*/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (exist(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int r, int c, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(idx)) {
            return false;
        }

        char temp = board[r][c];
        board[r][c] = '*';
        boolean exist = exist(board, r + 1, c, word, idx + 1) || exist(board, r - 1, c, word, idx + 1)
                || exist(board, r, c + 1, word, idx + 1) || exist(board, r, c - 1, word, idx + 1);
        board[r][c] = temp;
        return exist;
    }
}