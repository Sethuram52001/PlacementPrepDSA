/*
Problem:
The numeric value of a lowercase character is defined as its position (1-indexed) in the alphabet, 
so the numeric value of a is 1, the numeric value of b is 2, the numeric value of c is 3, and so on.

The numeric value of a string consisting of lowercase characters is defined as the sum of its characters' 
numeric values. For example, the numeric value of the string "abe" is equal to 1 + 2 + 5 = 8.

You are given two integers n and k. Return the lexicographically smallest string with length equal to 
n and numeric value equal to k.

Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, 
that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes 
before y[i] in alphabetic order.

Link: https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

Solution:
Greedy approach
*/

public class SmallestStringWithAGivenNumericValue {
    public String getSmallestString(int n, int k) {
        char[] ans = new char[n];
        Arrays.fill(ans, 'a');

        k -= n;
        while (n > 0 && k > 0) {
            int min = Math.min(25, k);
            ans[--n] = (char) (min + 'a');
            k -= min;
        }

        return new String(ans);
    }
}