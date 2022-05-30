/*
Problem:
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be 
truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: 
[−2^31, 2^31 − 1]. For this problem, if the quotient is strictly greater than 2^31 - 1, then return 2^31 - 1, and if the 
quotient is strictly less than -2^31, then return -2^31.

Link: https://leetcode.com/problems/divide-two-integers/submissions/ 

Solution:
We can use repeated subtraction to find the quotient, which can be improved with the help of 
bit manipulation.
e.g:-
Suppose dividend = 15 and divisor = 3, 15 - 3 > 0. We now try to subtract more by shifting 3 to 
the left by 1 bit (6). Since 15 - 6 > 0, shift 6 again to 12. Now 15 - 12 > 0, shift 12 again to 
24, which is larger than 15. So we can at most subtract 12 from 15. Since 12 is obtained by shifting 
3 to left twice, it is 1 << 2 = 4 times of 3. We add 4 to an answer variable (initialized to be 0). 
The above process is like 15 = 3 * 4 + 3. We now get part of the quotient (4), with a remaining dividend 3.

Reference: 1. https://leetcode.com/problems/divide-two-integers/discuss/13407/C%2B%2B-bit-manipulations
*/

public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        boolean isNegative = false;
        if (dividend < 0 && divisor > 0) {
            isNegative = true;
        } else if (dividend > 0 && divisor < 0) {
            isNegative = true;
        }

        int quotient = 0;
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        while (dvs <= dvd) {
            long temp = dvs, mul = 1;
            while (dvd >= temp << 1) {
                temp <<= 1;
                mul <<= 1;
            }
            dvd -= temp;
            quotient += mul;
        }
        return !isNegative ? quotient : -quotient;
    }
}