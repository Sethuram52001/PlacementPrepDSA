/*
Problem:
Given 3 positives numbers a, b and c. Return the minimum flips required in some bits of a and b to make ( a OR b == c ). 
(bitwise OR operation).
Flip operation consists of change any single bit 1 to 0 or change the bit 0 to 1 in their binary representation.

Link: https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/description/

Solution:
* Check the bits one by one whether they need to be flipped.
*/

public class MinimumFlipsToMakeAORBEqualToC {
    public int minFlips(int a, int b, int c) {
        int noOfFlips = 0;
        while (a != 0 || b != 0 || c != 0) {
            if ((c & 1) == 1) {
                if ((a & 1) == 0 && (b & 1) == 0) {
                    noOfFlips++;
                }
            } else {
                noOfFlips += (a & 1) + (b & 1);
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }

        return noOfFlips;
    }
}
