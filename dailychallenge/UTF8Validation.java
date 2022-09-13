/*
Problem:
Given an integer array data representing the data, return whether it is a valid UTF-8 encoding (i.e. it translates to a sequence of valid UTF-8 encoded characters).

A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

For a 1-byte character, the first bit is a 0, followed by its Unicode code.
For an n-bytes character, the first n bits are all one's, the n + 1 bit is 0, followed by n - 1 bytes with the most significant 2 bits being 10.
This is how the UTF-8 encoding would work:

     Number of Bytes   |        UTF-8 Octet Sequence
                       |              (binary)
   --------------------+-----------------------------------------
            1          |   0xxxxxxx
            2          |   110xxxxx 10xxxxxx
            3          |   1110xxxx 10xxxxxx 10xxxxxx
            4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
x denotes a bit in the binary form of a byte that may be either 0 or 1.

Note: The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data. This means each integer represents only 1 byte of data.

Link: https://leetcode.com/problems/utf-8-validation/

Solution:
Bit manipulation over string manipulation
*/

public class UTF8Validation {
    public boolean validUtf8(int[] data) {
        int mask1 = 1 << 7, mask2 = 1 << 6;
        int noOfBytes = 0;
        for (int idx = 0; idx < data.length; idx++) {
            if (noOfBytes == 0) {
                int mask = 1 << 7;
                while ((data[idx] & mask) != 0) {
                    noOfBytes++;
                    mask >>= 1;
                }

                if (noOfBytes == 0) {
                    continue;
                }

                if (noOfBytes > 4 || noOfBytes == 1) {
                    return false;
                }
            } else {
                if (!((data[idx] & mask1) != 0 && (mask2 & data[idx]) == 0)) {
                    return false;
                }
            }
            noOfBytes -= 1;
        }

        return noOfBytes == 0;
    }
}
