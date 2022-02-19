/*
Problem:
Given a string s, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.

Link:
https://leetcode.com/problems/repeated-substring-pattern/

Solution:
We can just check the match for every window size(where window size is based on the pattern we're checking for).
*/

public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for(int i = n/2; i >= 1; i--) {
            if(checkPattern(s, i)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkPattern(String s, int win) {
        int n = s.length();
        if(n % win != 0) {
            return false;
        }
        String pattern = s.substring(0, win);
        //System.out.println("pattern: " + pattern);
        
        for(int i = win; i < n; i += win) {
            if(!s.substring(i, i + win).equals(pattern)) {
                return false;
            }
            //System.out.println(s.substring(i, i + win));
        }
        return true;
    }
}