/*
Problem:
Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), 
we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to 
the same letter.

Link: https://leetcode.com/problems/find-and-replace-pattern/

Solution:
We can use a hashmap to map the characters seen to pattern and check.
To avoid edge cases like word="ccc" pattern = "abb"
we can maintain a hashset to maintain the characters which were seen in the word being tracked
*/

import java.util.*;

public class FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matches = new ArrayList<>();
        for (String word : words) {
            if (isValid(word, pattern)) {
                matches.add(word);
            }
        }
        return matches;
    }

    private boolean isValid(String word, String pattern) {
        if (word.length() != pattern.length()) {
            return false;
        }
        HashMap<Character, Character> h = new HashMap<>();
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < word.length(); i++) {
            char c1 = word.charAt(i), c2 = pattern.charAt(i);
            if (!h.containsKey(c2) && !seen.contains(c1)) {
                //System.out.println("key not present: "+ c1 + " " + c2);
                h.put(c2, c1);
                seen.add(c1);
            } else if (!h.containsKey(c2) && seen.contains(c1)) {
                return false;
            } else {
                if (h.get(c2) != c1) {
                    //System.out.println("key present but not equal: "+ c1 + " " + c2);
                    return false;
                }
            }
        }
        return true;
    }
}