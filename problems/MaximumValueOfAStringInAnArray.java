/*
Problem:
The value of an alphanumeric string can be defined as:
The numeric representation of the string in base 10, if it comprises of digits only.
The length of the string, otherwise.
Given an array strs of alphanumeric strings, return the maximum value of any string in strs.

Link: https://leetcode.com/problems/maximum-value-of-a-string-in-an-array/

Solution:
Regex 
*/

public class MaximumValueOfAStringInAnArray {
    public int maximumValue(String[] strs) {
        String regex = "[0-9]+";
        int maxValue = Integer.MIN_VALUE;
        
        for(String str : strs) {
            if(str.matches(regex)) {
                maxValue = Math.max(maxValue, Integer.parseInt(str));
            } else {
                maxValue = Math.max(maxValue, str.length());
            }
        }
        
        return maxValue;
    }
}
