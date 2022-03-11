/*
Problem:
Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Link: https://leetcode.com/problems/backspace-string-compare/

Solution:
2 pointer
*/

public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int sPtr = s.length() - 1, tPtr = t.length() - 1;
        int backspace = 0;
        
        while(true) {
            backspace = 0;
            while(sPtr >= 0 && (s.charAt(sPtr) == '#' || backspace > 0)) {
                if(s.charAt(sPtr) == '#') {
                    backspace++;
                }
                else {
                    backspace--;
                }
                sPtr--;
            }
            
            backspace = 0;
            while(tPtr >= 0 && (t.charAt(tPtr) == '#' || backspace > 0)) {
                if(t.charAt(tPtr) == '#') {
                    backspace++;
                }
                else {
                    backspace--;
                }
                tPtr--;
            }
            
            if(sPtr < 0 || tPtr < 0) {
                break;
            }
            
            if(s.charAt(sPtr--) != t.charAt(tPtr--)) {
                return false;
            }
        }
        
        return sPtr < 0 && tPtr < 0;
    }   
}