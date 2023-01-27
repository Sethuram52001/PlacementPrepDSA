/*
Problem:
Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.

A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.

Link: https://leetcode.com/problems/concatenated-words/description/

Solution:
1. Build a trie.
2. While searching have a parameter to keep track of the number of words makes up the current word.

Reference:
1. https://leetcode.com/problems/concatenated-words/solutions/280915/java-41ms-trie-and-dfs-solution-which-beats-97/?orderBy=most_votes&topicTags=trie
*/

import java.util.*;

public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            buildTrie(root, word);
        }

        List<String> results = new ArrayList<>();
        for (String word : words) {
            if (search(root, word, 0, 0)) {
                results.add(word);
            }
        }

        return results;
    }

    // count - number of words it is comprised of(current word)
    private boolean search(Trie root, String word, int start, int count) {
        Trie curr = root;
        for (int i = start; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }

            curr = curr.children[idx];
            if (curr.isWord && search(root, word, i + 1, count + 1)) {
                return true;
            }
        }

        return count >= 1 && curr.isWord;
    }

    private class Trie {
        Trie[] children = new Trie[26];
        boolean isWord = false;
    }

    private void buildTrie(Trie root, String word) {
        Trie curr = root;
        for (int idx = 0; idx < word.length(); idx++) {
            int index = word.charAt(idx) - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Trie();
            }

            curr = curr.children[index];
        }

        curr.isWord = true;
    }
}
