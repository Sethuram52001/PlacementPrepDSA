/*
Problem:
You are given a positive integer num consisting only of digits 6 and 9.
Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).

Link: https://leetcode.com/problems/maximum-69-number/description/

Solution:
Find the largest place value where 6 appears, then add
3*10^place_value_of_6 to the number.
*/

public class Maximum69Number {
    public int maximum69Number(int num) {
        int n = num;
        int pos = -1;
        int placeValue = 0;
        while (n > 0) {
            if (n % 10 == 6) {
                pos = placeValue;
            }
            n /= 10;
            placeValue++;
        }

        if (pos == -1) {
            return num;
        }

        return num + 3 * (int) Math.pow(10, pos);
    }
}
