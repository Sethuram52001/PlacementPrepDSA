/*
Problem:
A pangram is a sentence where every letter of the English alphabet appears at least once.
Given a string sentence containing only lowercase English letters, return true if sentence is a pangram, or false otherwise.

Link: https://leetcode.com/problems/check-if-the-sentence-is-pangram/

Solution:
hashing
*/

public class CheckIfTheSentenceIsPangram {
    public boolean checkIfPangram(String sentence) {
        int[] count = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            count[sentence.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] == 0) {
                return false;
            }
        }
        return true;
    }
}