/*
Problem:
In an alien language, surprisingly, they also use English lowercase letters, but possibly in a different order.
The order of the alphabet is some permutation of lowercase letters.

Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only 
if the given words are sorted lexicographically in this alien language.

Link: https://leetcode.com/problems/verifying-an-alien-dictionary/description/

Solution: 
hashing - map/dictionary
*/

public class VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        int[] alienOrder = new int[26];
        for (int idx = 0; idx < order.length(); idx++) {
            char ch = order.charAt(idx);
            alienOrder[ch - 'a'] = idx;
        }

        for (int i = 0; i < words.length - 1; i++) {
            if (isBigger(words[i], words[i + 1], alienOrder)) {
                return false;
            }
        }

        return true;
    }

    private boolean isBigger(String word1, String word2, int[] alienOrder) {
        for (int i = 0; i < Math.min(word1.length(), word2.length()); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                return alienOrder[word1.charAt(i) - 'a'] > alienOrder[word2.charAt(i) - 'a'];
            }
        }

        return word1.length() > word2.length();
    }
}