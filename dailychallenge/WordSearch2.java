/*
Problem:
Given an m x n board of characters and a list of strings words, return all words on the board.
Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells 
are horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

Link: https://leetcode.com/problems/word-search-ii/description/

Solution: 
Build a trie and perform dfs on it, for searching words.
*/

import java.util.*;

public class WordSearch2 {
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTree(words);
        List<String> wordsOnBoard = new ArrayList<>();
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                dfs(board, r, c, root, wordsOnBoard);
            }
        }

        return wordsOnBoard;
    }

    private void dfs(char[][] board, int r, int c, TrieNode root, List<String> wordsOnBoard) {
        if (r < 0 || r == board.length || c < 0 || c == board[0].length) {
            return;
        }

        char ch = board[r][c];
        if (board[r][c] == '*' || root.children[ch - 'a'] == null) {
            return;
        }

        root = root.children[ch - 'a'];
        if (root.word != null) {
            wordsOnBoard.add(root.word);
            root.word = null;
        }

        board[r][c] = '*';
        dfs(board, r + 1, c, root, wordsOnBoard);
        dfs(board, r - 1, c, root, wordsOnBoard);
        dfs(board, r, c + 1, root, wordsOnBoard);
        dfs(board, r, c - 1, root, wordsOnBoard);
        board[r][c] = ch;
    }

    private TrieNode buildTree(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode curr = root;
            for (char ch : word.toCharArray()) {
                if (curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.word = word;
        }

        return root;
    }

    private class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }
}
