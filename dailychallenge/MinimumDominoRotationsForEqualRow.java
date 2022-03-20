/*
Problem:
In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom halves of the ith domino. 
(A domino is a tile with two numbers from 1 to 6 - one on each half of the tile.)

We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.

Return the minimum number of rotations so that all the values in tops are the same, or all the values 
in bottoms are the same.

If it cannot be done, return -1.

Link: https://leetcode.com/problems/minimum-domino-rotations-for-equal-row/

Solution:
We can use a 3 freq array:
i. topFreq array, ii. bottomFreq array, iii. sameElement

Now, we can loop through 1 to 6 and check for:
topFreq[i] - bottomFreq[i] - same[i] >= tops.length
if so, we return Math.min(topFreq[i], bottomFreq[i]) - same[i]
*/

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] topFreq, bottomFreq, same;
        topFreq = new int[7];
        bottomFreq = new int[7];
        same = new int[7];

        for (int i = 0; i < tops.length; i++) {
            topFreq[tops[i]]++;
            bottomFreq[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }

        for (int i = 1; i <= 6; i++) {
            if (topFreq[i] + bottomFreq[i] - same[i] >= tops.length) {
                return Math.min(topFreq[i], bottomFreq[i]) - same[i];
            }
        }

        return -1;
    }
}