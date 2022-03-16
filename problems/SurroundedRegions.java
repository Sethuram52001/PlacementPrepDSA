/*
Problem:
Given an m x n matrix board containing 'X' and 'O', capture all regions that are 4-directionally surrounded by 'X'.

A region is captured by flipping all 'O's into 'X's in that surrounded region.

Link: https://leetcode.com/problems/surrounded-regions/

Solution:
We can't conver the 'O's which are connected to 'O's which are present in the boundary, 
so we can do a dfs and mark all 'O's connected to the boundary as '*' special character.
Then,  we can do post-processing to convert the remaining 'O's to 'X' as it can be captured
and convert all '*'s back to 'O's.
*/

public class SurroundedRegions {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        if(n <= 1 || m <= 1) {
            return;
        }
        
        // first col and last col
        for(int r = 0; r < n ; r++) {
            if(board[r][0] == 'O') {
                dfs(board, r, 0);
            }
            if(board[r][m - 1] == 'O') {
                dfs(board, r, m - 1);
            }
        }
        
        // first row and last row
        for(int c = 0; c < m; c++) {
            if(board[0][c] == 'O') {
                dfs(board, 0, c);
            }
            if(board[n - 1][c] == 'O') {
                dfs(board, n - 1, c);
            }
        }
        
        for(int r = 0; r < n; r++) {
            for(int c = 0; c < m; c++) {
                if(board[r][c] == 'O') {
                    board[r][c] = 'X';
                }
                if(board[r][c] == '*') {
                    board[r][c] = 'O';
                }
            }
        }
    }
    
    private void dfs(char[][] board, int r, int c) {
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length) {
            return;
        }
       
        if(board[r][c] == 'O') {
            board[r][c] = '*';

            dfs(board, r - 1, c);
            dfs(board, r + 1, c);
            dfs(board, r, c - 1);
            dfs(board, r, c + 1);
        }
    }   
}