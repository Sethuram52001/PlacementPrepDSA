/*
Problem:
You are given two string arrays, queries and dictionary. All words in each array comprise of 
lowercase English letters and have the same length.

In one edit you can take a word from queries, and change any letter in it to any other letter. 
Find all words from queries that, after a maximum of two edits, equal some word from dictionary.

Return a list of all words from queries, that match with some word from dictionary after a maximum 
of two edits. Return the words in the same order they appear in queries.

Link: https://leetcode.com/problems/words-within-two-edits-of-dictionary/

Solution:
Brute force
*/

import java.util.*;

public class WordsWithinTwoEditsOfDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> words = new ArrayList<>();
        for(String word : queries) {
            if(withinEdit(word, dictionary)) {
                words.add(word);
            }
        }
        
        return words;
    }
    
    private boolean withinEdit(String word_, String[] dict) {
        char[] word = word_.toCharArray(); 
        for(String d : dict) {
            if(check(word, d.toCharArray())) {
                return true;
            }
        }
        return false;
    }
    
    private boolean check(char[] word1, char[] word2) {
        int count = 0;
        for(int idx = 0; idx < word1.length; idx++) {
            count += (word1[idx] == word2[idx]) ? 0 : 1;
            if(count > 2) {
                return false;
            }
        }
        return true;
    }
}
