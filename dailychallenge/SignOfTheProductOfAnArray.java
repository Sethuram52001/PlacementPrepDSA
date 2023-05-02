/*
Problem:
There is a function signFunc(x) that returns:

1 if x is positive.
-1 if x is negative.
0 if x is equal to 0.
You are given an integer array nums. Let product be the product of all values in the array nums.

Return signFunc(product).

Link: https://leetcode.com/problems/sign-of-the-product-of-an-array/description/

Solution:
If you find a zero then return 0, else count the number of negative numbers.
Return 1 if no of negative numbers is even else return 0.
*/

public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int noOfNegativeNumbers = 0;

        for (int n : nums) {
            if (n == 0) {
                return 0;
            } else if (n < 0) {
                noOfNegativeNumbers++;
            }
        }

        return noOfNegativeNumbers % 2 == 0 ? 1 : -1;
    }
}
