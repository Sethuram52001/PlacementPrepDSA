/*
Problem:
You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents
 that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.

Link: https://leetcode.com/problems/maximize-distance-to-closest-person/

Solution:
In a group of K adjacent empty seats between two people, the answer is (K+1) / 2.
*/

public class MaximizeDistanceToClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int k = 0;
        int maxDist = 0;

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                int currDist = (k + 1) / 2;
                maxDist = Math.max(maxDist, currDist);
                k = 0;
            } else {
                k++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (seats[i] == 1) {
                maxDist = Math.max(maxDist, i);
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (seats[i] == 1) {
                maxDist = Math.max(maxDist, n - i - 1);
                break;
            }
        }

        return maxDist;
    }

    public int maxDistToClosest_(int[] seats) {
        int n = seats.length;
        int maxFromLeftCorner = -1, maxFromRightCorner = -1;
        if (seats[0] == 0) {
            int dist = 1;
            for (int i = 1; i < n; i++) {
                if (seats[i] == 1) {
                    break;
                }
                dist++;
            }
            maxFromLeftCorner = dist;
        }

        if (seats[n - 1] == 0) {
            int dist = 1;
            for (int i = n - 2; i >= 0; i--) {
                if (seats[i] == 1) {
                    break;
                }
                dist++;
            }
            maxFromRightCorner = dist;
        }

        int currPos = 0, maxDistPos = -1, maxDist = -1;

        for (; currPos <= n - 2; currPos++) {
            if (seats[currPos] == 1) {
                continue;
            }
            int left = currPos - 1, right = currPos + 1;
            int dist = 1;
            while (left >= 0 && right < n && seats[left] != 1 && seats[right] != 1) {
                dist += 1;
                left--;
                right++;
            }
            //System.out.println("dist: " + dist);
            if (dist > maxDist) {
                maxDist = dist;
                maxDistPos = currPos;
            }
            //System.out.println("max dist pos: " + maxDistPos);
        }

        //System.out.println(maxFromLeftCorner);
        //System.out.println(maxFromRightCorner);

        if (maxFromLeftCorner > maxDist) {
            maxDistPos = 0;
            maxDist = maxFromLeftCorner;
        }
        if (maxFromRightCorner > maxDist) {
            maxDistPos = n - 1;
            maxDist = maxFromRightCorner;
        }

        return maxDist;
    }
}
