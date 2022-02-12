/*
Problem:
A transformation sequence from word beginWord to word endWord using a dictionary wordList is a sequence of words 
beginWord -> s1 -> s2 -> ... -> sk such that:

* Every adjacent pair of words differs by a single letter.
* Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
* sk == endWord

Given two words, beginWord and endWord, and a dictionary wordList, return the number of words in the shortest transformation sequence from 
beginWord to endWord, or 0 if no such sequence exists.

Link: https://leetcode.com/problems/word-ladder/

Solution:
We can think this problem as a graph problem.
Each transformation connects one node to another node(node here is the string).
Now, we can do BFS to find the shortest path, which will be the shortest transformation sequence from beginWord to endWord.
*/

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>();
        words.addAll(wordList);

        if (!words.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.add(beginWord);

        int level = 1;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                char[] currWord = q.poll().toCharArray();
                for (int idx = 0; idx < currWord.length; idx++) {
                    char orgChar = currWord[idx];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (orgChar == ch) {
                            continue;
                        }

                        currWord[idx] = ch;
                        String newWord = new String(currWord);

                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }

                        if (words.contains(newWord)) {
                            words.remove(newWord);
                            q.add(newWord);
                        }

                        currWord[idx] = orgChar;
                    }
                }
            }
            level++;
        }

        return 0;
    }
}