/*
Problem:
Given four integers length, width, height, and mass, representing the dimensions and mass of a box, 
respectively, return a string representing the category of the box.

The box is "Bulky" if:
Any of the dimensions of the box is greater or equal to 104.
Or, the volume of the box is greater or equal to 109.
If the mass of the box is greater or equal to 100, it is "Heavy".
If the box is both "Bulky" and "Heavy", then its category is "Both".
If the box is neither "Bulky" nor "Heavy", then its category is "Neither".
If the box is "Bulky" but not "Heavy", then its category is "Bulky".
If the box is "Heavy" but not "Bulky", then its category is "Heavy".
Note that the volume of the box is the product of its length, width and height.

Link: https://leetcode.com/problems/categorize-box-according-to-criteria/description/

Solution:
Use big integer to avoid overflow problems.
*/

import java.math.BigInteger;

public class CategorizeBoxAccordingToCriteria {
    public String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = false, heavy = mass >= 100;
        long v_limit = (long) Math.pow(10, 9);
        BigInteger l = BigInteger.valueOf(length), w = BigInteger.valueOf(width), h = BigInteger.valueOf(height);
        BigInteger volume = l.multiply(w.multiply(h));
        System.out.println("volume: " + volume);
        int limit = (int) Math.pow(10, 4);
        if (length >= limit || width >= limit || height >= limit
                || volume.compareTo(BigInteger.valueOf(v_limit)) >= 0) {
            bulky = true;
        }

        return (bulky && heavy) ? "Both" : (!bulky && !heavy) ? "Neither" : bulky ? "Bulky" : "Heavy";
    }
}
