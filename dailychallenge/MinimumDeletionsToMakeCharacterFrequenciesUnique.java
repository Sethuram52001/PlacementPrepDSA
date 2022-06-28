/*
Problem:
A string s is called good if there are no two different characters in s that have the same frequency.

Given a string s, return the minimum number of characters you need to delete to make s good.

The frequency of a character in a string is the number of times it appears in the string. For example, 
in the string "aab", the frequency of 'a' is 2, while the frequency of 'b' is 1. 

Link: https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/

Solution:
The idea is simple, we have to move the letters with duplicate frequencies to the next 
availabe unused frequency, and if there are no available frequencies we delete the string as a whole
as '0' frequency doesn't count towards uniqueness of the set.

To solve this, we can maintain frequency array and iterate over it, while doing so we check
if this frequency has occurred early(which can be kept track using a hashset) if so we try deleting a character
and look for open spots in frequencies, else we delete it if there no available frequencies.
*/

import java.util.*;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
    public int minDeletions(String s) {
        char[] freq = new char[26];
        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int deletions = 0;
        HashSet<Integer> uniqueFreq = new HashSet<>();
        for (int i = 0; i < 26; i++) {
            int f = freq[i];
            if (f > 0) {
                while (f > 0) {
                    if (!uniqueFreq.contains(f)) {
                        uniqueFreq.add(f);
                        break;
                    }
                    deletions++;
                    f--;
                }
            }
        }
        return deletions;
    }
}