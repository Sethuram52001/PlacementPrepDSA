/*
Problem: 
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.

Link: https://leetcode.com/problems/sequential-digits/

Solution:
Sliding window : we can maintain a digits string and we can slide the window along the string to
check for validity and increase the window size on the next turn if necessary
*/

import java.util.*;

public class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> seqDigits = new ArrayList<>();
        String digits = "123456789";
        
        int win = noOfDigits(low);
        int maxWinSize = noOfDigits(high);
        
        while(win <= maxWinSize) {
            for(int idx = 0; idx < 9 - win + 1; idx++) {
                int value = Integer.valueOf(digits.substring(idx, idx + win));
                if(value >= low && value <= high) {
                    seqDigits.add(value);
                }
            }
            win++;
        }
        
        return seqDigits;
    }
    
    private int noOfDigits(int num) {
        int n = 0;
        while(num > 0) {
            n++;
            num /= 10;
        }
        return n;
    }    
}