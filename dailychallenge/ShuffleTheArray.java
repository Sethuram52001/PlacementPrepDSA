/*
Problem:
Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].
Return the array in the form [x1,y1,x2,y2,...,xn,yn].

Link: https://leetcode.com/problems/shuffle-the-array/description/

Solution:
Bit-manipulation:
The maximum possible value in the array is 10^3 => 1111101000 in binary.
So in the 2^32 bit integer element we can store the pair of each value => xn, yn => yn bits | xn bits => y << 10 | x

We can use the mask to retreive the elements:
mask = 0000000000 1111111111
*/

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        for(int i = 0; i < n; i++) {
            int secondPart = nums[i + n] << 10;
            nums[i] |= secondPart;
        }

        int mask = (int)Math.pow(2, 10) - 1; // 0000000000 1111111111
        for(int i = n - 1; i >= 0; i--) {
            int secondPart = nums[i] >> 10;
            int firstPart = nums[i] & mask;
            nums[2*i] = firstPart;
            nums[2*i + 1] = secondPart;
        }

        return nums;
    }
}
