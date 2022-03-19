/*
Problem:
You are given a string s. We want to partition the string into as many parts as possible so that each 
letter appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string
should be s.

Return a list of integers representing the size of these parts.

Link: https://leetcode.com/problems/partition-labels/

Solution:
Greedy: Consider the first label, say it's 'a'. The first partition must include it, and also the last occurrence of 'a'. 
However, between those two occurrences of 'a', there could be other labels that make the minimum size of this partition bigger. 
For example, in "abccaddbeffe", the minimum first partition is "abccaddb". This gives us the idea for the algorithm: 
For each letter encountered, process the last occurrence of that letter, extending the current partition [anchor, j] appropriately.
*/

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> partitions = new ArrayList<>();

        int[] lastSeen = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        int boundary = 0, count = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boundary = Math.max(boundary, lastSeen[ch - 'a']);
            count++;

            if (i == boundary) {
                partitions.add(count);
                count = 0;
            }
        }

        return partitions;
    }
}