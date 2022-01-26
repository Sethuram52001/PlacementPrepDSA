/*
Problem:
Given a string s and a dictionary of strings wordDict, add spaces in s to construct a sentence where each word is a valid dictionary word. 
Return all such possible sentences in any order.

Note that the same word in the dictionary may be reused multiple times in the segmentation.

Link: https://leetcode.com/problems/word-break-ii/

Solution:
We can use dfs with memoization to solve this problem.
*/

import java.util.*;

public class WordBreak2 {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return backtrack(s, wordDict, new HashMap<String, List<String>>());
    }

    private List<String> backtrack(String s, List<String> wordDict, HashMap<String, List<String>> h) {
        if (h.containsKey(s)) {
            return h.get(s);
        }

        List<String> combination = new ArrayList<>();

        for (String word : wordDict) {
            if (s.indexOf(word) == 0) {
                String next = s.substring(word.length());
                if (next.isEmpty()) {
                    combination.add(word);
                } else {
                    List<String> subCombination = backtrack(next, wordDict, h);
                    for (String i : subCombination) {
                        combination.add(word + " " + i);
                    }
                }
            }
        }

        h.put(s, combination);
        return combination;
    }
}