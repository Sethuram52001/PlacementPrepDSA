/*
Problem:
For two strings s and t, we say "t divides s" if and only if s = t + ... + t (i.e., t is concatenated 
with itself one or more times).

Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

Link: https://leetcode.com/problems/greatest-common-divisor-of-strings/description/

Solution:
1. brute force
2. str1 + str2 == str2 + str1 is true then there must be a common divisor else return "", if it is true, the common
divisor is just the str1.substring(0, gcd(str1.length(), str2.length()))

Reference:
1. https://leetcode.com/problems/greatest-common-divisor-of-strings/solutions/3024822/greatest-common-divisor-of-strings/
*/

import java.util.*;
public class GreatestCommonDivisorOfStrings {
        public String gcdOfStrings(String str1, String str2) {
        String join1 = str1 + str2;
        String join2 = str2 + str1;
        if(!join1.equals(join2)) {
            return "";
        }

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }

        return gcd(y, x % y);
    }
    
    public String gcdOfStrings_(String str1, String str2) {
        if(str1.length() > str2.length()) {
            return gcdOfStrings(str2, str1);
        }

        for(int idx = str1.length(); idx > 0; idx--) {
            if(isValid(str1, str2, idx)) {
                return str1.substring(0, idx);
            }
        }
        
        return "";
    }

    private boolean isValid(String str1, String str2, int len) {
        int n1 = str1.length(), n2 = str2.length();
        if(n1 % len > 0 || n2 % len > 0) {
            return false;
        }

        String base = str1.substring(0, len);
        System.out.println(base.repeat(n1 / len) + " " + base.repeat(n2 / len)); 
        return str1.equals(base.repeat(n1 / len)) && str2.equals(base.repeat(n2 / len));
    }    
}
