/*
Problem:
Given two string arrays word1 and word2, return true if the two arrays represent the same string, 
and false otherwise.
A string is represented by an array if the array elements concatenated in order forms the string.

Link: https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/

Solution:
Concatenate the word and check for equality.
*/

public class CheckIfTwoStringArraysAreEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String concat1 = "", concat2 = "";
        for (String word : word1) {
            concat1 += word;
        }

        for (String word : word2) {
            concat2 += word;
        }

        return concat1.equals(concat2);
    }
}
