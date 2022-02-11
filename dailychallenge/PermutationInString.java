/*
Problem:
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
In other words, return true if one of s1's permutations is the substring of s2.

Link: https://leetcode.com/problems/permutation-in-string/

Solution:
We can use sliding window and hashing to solve this, similar to "Find all anagrams in a string".
*/

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int s2Len = s2.length();

        if (s2Len < s1Len) {
            return false;
        }

        int[] count1 = new int[26];
        int[] count2 = new int[26];

        for (int i = 0; i < s1Len; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2Len - s1Len; i++) {
            if (isPermutation(count1, count2)) {
                return true;
            }
            count2[s2.charAt(i) - 'a']--;
            count2[s2.charAt(i + s1Len) - 'a']++;
        }

        return isPermutation(count1, count2);
    }

    private boolean isPermutation(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
                return false;
            }
        }
        return true;
    }
}