/*
Problem:
Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be 
built with those letters.

Letters are case sensitive, for example, "Aa" is not considered a palindrome here.

Link: https://leetcode.com/problems/longest-palindrome/

Solution:
For each letter, say it occurs v times. We know we have v // 2 * 2 letters that can be partnered for sure. For example, 
if we have 'aaaaa', then we could have 'aaaa' partnered, which is 5 // 2 * 2 = 4 letters partnered.

At the end, if there was any v % 2 == 1, then that letter could have been a unique center. Otherwise, every letter was 
partnered. To perform this check, we will check for v % 2 == 1 and ans % 2 == 0, the latter meaning we haven't yet 
added a unique center to the answer.
*/

import java.util.*;

public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] freqMap = new int[128];
        for (char c : s.toCharArray()) {
            freqMap[(int) c]++;
        }

        int count = 0;
        for (int i : freqMap) {
            count += i / 2 * 2; // 5 =>  5 / 2 * 2 = 2 * 2 = 4
            if (count % 2 == 0 && i % 2 == 1) {
                count++;
            }
        }

        return count;
    }
    
    public int longestPalindrome_Extra_space(String s) {
        HashSet<Character> set = new HashSet<>();
        int count = 0;
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                set.remove(c);
                count += 1;
            }
            else {
                set.add(c);
            }
        }
        
        return !set.isEmpty() ? count*2 + 1 : count*2;
    }
}
