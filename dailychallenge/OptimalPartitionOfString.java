/*
Problem:
Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. 
That is, no letter appears in a single substring more than once.

Return the minimum number of substrings in such a partition.

Note that each character should belong to exactly one substring in a partition.

Link: https://leetcode.com/problems/optimal-partition-of-string/

Solution:
1. set
2. bit manipulation
*/

import java.util.*;

public class OptimalPartitionOfString {
        public int partitionString(String s) {
        int partitions = 1, flag = 0;
        for(char ch : s.toCharArray()) {
            int val = ch - 'a';
            if((flag & (1 << val)) != 0) {
                partitions++;
                flag = 0;
            }
            flag |= (1 << val);
        }

        return partitions;
    }
        public int partitionString_(String s) {
        Set<Character> set = new HashSet<>();
        int partitions = 1;
        for(char ch : s.toCharArray()) {
            if(set.contains(ch)) {
                partitions++;
                set.clear();
            }
            set.add(ch);
        }

        return partitions;
    }
}

