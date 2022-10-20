/*
Problem:
Given an integer, convert it to a roman numeral.

Link: https://leetcode.com/problems/integer-to-roman/

Solution: 
Maintain two arrays, i. for values and ii. for roman numerals.
Iterate over the number and perform the calculations.
*/

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] values = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] romans = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            for(int i = romans.length - 1; i >= 0; i--) {
                if(num >= values[i]) {
                    sb.append(romans[i]);
                    num -= values[i];
                    break;
                }
            }
        }
        
        return sb.toString();
    }    
}
