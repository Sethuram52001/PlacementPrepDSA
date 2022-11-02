/*
Problem:
A gene string can be represented by an 8-character long string, with choices from 'A', 'C', 'G', and 'T'.

Suppose we need to investigate a mutation from a gene string start to a gene string end where one mutation 
is defined as one single character changed in the gene string.

For example, "AACCGGTT" --> "AACCGGTA" is one mutation.
There is also a gene bank bank that records all the valid gene mutations. A gene must be in bank to make it 
a valid gene string.

Given the two gene strings start and end and the gene bank bank, return the minimum number of mutations needed 
to mutate from start to end. If there is no such a mutation, return -1.

Note that the starting point is assumed to be valid, so it might not be included in the bank.

Link: https://leetcode.com/problems/minimum-genetic-mutation/

Solution:
Do a BFS on the starting word, with the logic to suit given conditions.
*/

import java.util.*;

public class MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {
        char[] geneChoices = new char[] { 'A', 'C', 'G', 'T' };
        List<String> Bank = Arrays.asList(bank);
        Set<String> visited = new HashSet<>();
        Deque<String> queue = new ArrayDeque<>();
        queue.add(start);
        visited.add(start);
        int minMutations = 0;

        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                char[] curr = queue.remove().toCharArray();
                if (end.equals(new String(curr))) {
                    return minMutations;
                }

                for (int i = 0; i < 8; i++) {
                    char temp = curr[i];
                    for (int j = 0; j < 4; j++) {
                        curr[i] = geneChoices[j];
                        String next = new String(curr);
                        if (!visited.contains(next) && Bank.contains(next)) {
                            queue.add(next);
                            visited.add(next);
                        }
                    }
                    curr[i] = temp;
                }
            }
            minMutations++;
        }

        return -1;
    }
}
