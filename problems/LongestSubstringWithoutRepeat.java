import java.util.*;

/*
 Problem: 
 Given a string s, find the length of the longest substring without repeating characters.

 Link: https://leetcode.com/problems/longest-substring-without-repeating-characters/

 Solution:
 We can have 2 pointers and a set to remember all the characters appeared
*/

public class LongestSubstringWithoutRepeat {
    private static int lengthOfLongestSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> h = new HashMap<>();
        int l = 0, r = 0;
        while (r < s.length()) {
            if (h.containsKey(s.charAt(r))) {
                l = Math.max(l, h.get(s.charAt(r)) + 1);
            }
            h.put(s.charAt(r), r);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
