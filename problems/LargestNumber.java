/*
Problem:
Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.
Since the result may be very large, so you need to return a string instead of an integer.

Link: https://leetcode.com/problems/largest-number/

Solution:
First, we convert each integer to a string. Then, we sort the array of strings.

While it might be tempting to simply sort the numbers in descending order, this causes 
problems for sets of numbers with the same leading digit. For example, sorting the problem 
example in descending order would produce the number 95343039534303, while the correct 
answer can be achieved by transposing the 33 and the 3030. Therefore, for each pairwise 
comparison during the sort, we compare the numbers achieved by concatenating the pair in both orders.
*/

import java.util.*;

public class LargestNumber {
        public String largestNumber(int[] nums) {
        String[] stringNumbers = new String[nums.length];
        for(int i = 0; i < nums.length; i++) {
            stringNumbers[i] = String.valueOf(nums[i]);
        }
        
        Arrays.sort(stringNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        if(stringNumbers[0].equals("0")) {
            return "0";
        }
        
        StringBuilder sb = new StringBuilder();
        for(String num : stringNumbers) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}