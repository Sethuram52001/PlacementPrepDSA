/*
Problem:
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if 
the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit character or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary 
(from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, 
integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.


Link: https://leetcode.com/problems/string-to-integer-atoi/

Solution:
Just follow the algorithm given in the question
*/

public class StringToIntegerATOI {
    public int myAtoi(String s) {
        s = s.trim();
        if (s.length() == 0 || s == null) {
            return 0;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == ' ') {
            left++;
        }

        while (left < right && s.charAt(right) == ' ') {
            right--;
        }

        char firstChar = s.charAt(left);
        boolean positive = true;
        long res = 0;

        if (firstChar == '+') {
            positive = true;
        } else if (firstChar == '-') {
            positive = false;
        } else if (!Character.isDigit(firstChar)) {
            return 0;
        } else {
            res = firstChar - '0';
        }

        for (int i = left + 1; i <= right; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                break;
            }
            res *= 10;
            res += s.charAt(i) - '0';

            if (res > Integer.MAX_VALUE) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return positive ? (int) res : (int) -res;
    }
}