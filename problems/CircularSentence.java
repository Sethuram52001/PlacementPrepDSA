/*
Problem:
A sentence is a list of words that are separated by a single space with no leading or trailing spaces.

For example, "Hello World", "HELLO", "hello world hello world" are all sentences.
Words consist of only uppercase and lowercase English letters. Uppercase and lowercase English letters are 
considered different.

A sentence is circular if:

The last character of a word is equal to the first character of the next word.
The last character of the last word is equal to the first character of the first word.
For example, "leetcode exercises sound delightful", "eetcode", "leetcode eats soul" are all circular sentences. 
However, "Leetcode is cool", "happy Leetcode", "Leetcode" and "I like Leetcode" are not circular sentences.

Given a string sentence, return true if it is circular. Otherwise, return false.

Link: https://leetcode.com/problems/circular-sentence/
*/

public class CircularSentence {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        char firstChar = words[0].charAt(0);
        char lastChar = words[words.length - 1].charAt(words[words.length - 1].length() - 1);
        for (int idx = 0; idx < words.length - 1; idx++) {
            char c1 = words[idx].charAt(words[idx].length() - 1);
            char c2 = words[idx + 1].charAt(0);
            if (c1 != c2) {
                return false;
            }
        }

        return firstChar == lastChar;
    }
}
