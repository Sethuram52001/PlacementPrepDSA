/*
Problem:
Given a pattern and a string s, find if s follows the same pattern.
Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.

Link: https://leetcode.com/problems/word-pattern/

Solution:
We can use a hashmap to map the characters present in the character to the words present in the array
But there is an edge case 
"abba"
"dog dog dog dog"

To solve this we can use a hashset to store the covered words in the string so far or read the note below which can be done simply with
the help of a method in hashmap
Note:
The java.util.HashMap.containsValue() method is used to check whether a particular value is being mapped by a single or more 
than one key in the HashMap. It takes the Value as a parameter and returns True if that value is mapped by any of the key in the map.
*/

import java.util.*;
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s");
        int n = words.length;
        int patLen = pattern.length();

        if (n % patLen != 0) {
            return false;
        }

        HashMap<Character, String> patternToWord = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char ch = pattern.charAt(i % patLen);
            if (patternToWord.containsKey(ch) && patternToWord.get(ch).equals(words[i])) {
                continue;
            } else if (!patternToWord.containsKey(ch) && !patternToWord.containsValue(words[i])) {
                patternToWord.put(ch, words[i]);
            } else {
                return false;
            }
        }

        return true;
    }
}
