/*
Problem:
You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). 
Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a 
height greater than or equal to hi.

Reconstruct and return the queue that is represented by the input array people. The returned queue should be 
formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the queue 
(queue[0] is the person at the front of the queue).

Link: https://leetcode.com/problems/queue-reconstruction-by-height/

Solution:
Pick out tallest group of people and sort them in a subarray (S). Since there's no other groups of people taller than 
them, therefore each guy's index will be just as same as his k value.
For 2nd tallest group (and the rest), insert each one of them into (S) by k value. So on and so forth.
E.g.
input: [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
subarray after step 1: [[7,0], [7,1]]
subarray after step 2: [[7,0], [6,1], [7,1]]
*/

import java.util.*;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++)
            list.add(people[i][1], people[i]);

        return list.toArray(people);
    }
}