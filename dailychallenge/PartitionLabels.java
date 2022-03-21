/*
Problem:
You are given a string s. We want to partition the string into as many parts as possible so that each letter 
appears in at most one part.

Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.

Return a list of integers representing the size of these parts.

Link: https://leetcode.com/problems/partition-labels/

Solution:
Solved partition labels using hashing algorithm.
*/

public class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        int lastSeen[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i) - 'a'] = i;
        }

        List<Integer> partitions = new ArrayList<>();
        int start = 0, boundary = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            boundary = Math.max(boundary, lastSeen[ch - 'a']);
            if (boundary == i) {
                partitions.add(i - start + 1);
                start = i + 1;
                boundary = 0;
            }
        }

        return partitions;
    }
}