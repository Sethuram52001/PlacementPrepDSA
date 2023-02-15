/*
Problem:
The array-form of an integer num is an array representing its digits in left to right order.

For example, for num = 1321, the array form is [1,3,2,1].
Given num, the array-form of an integer, and an integer k, return the array-form of the integer num + k.

Link: https://leetcode.com/problems/add-to-array-form-of-integer/description/

Solution:
Simple logic - traverse from lowest unit place digit to highest units place digit(right to left)
*/

import java.util.*;

public class AddToArrayFormOfInteger {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> res = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0 || k > 0 || carry > 0; i--) {
            int sum = carry;
            if (i >= 0) {
                sum += num[i];
            }
            if (k > 0) {
                sum += k % 10;
            }
            carry = sum / 10;
            res.add(sum % 10);
            k /= 10;
        }

        Collections.reverse(res);
        return res;
    }
}