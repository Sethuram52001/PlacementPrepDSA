/*
Problem:
You have n  tiles, where each tile has one letter tiles[i] printed on it.
Return the number of possible non-empty sequences of letters you can make using 
the letters printed on those tiles.

Link: https://leetcode.com/problems/letter-tile-possibilities/

Solution:
This problem is the combination of 90. Subsets II and 47. Permutations II. What we need to calculate 
is the number of distinct sub-permutation of input array. The key is removing duplicate elements and 
counting the number of distinct sub-permutation:

Duplicate removal is the same as 47. Permutations II where we need to sort the array first and judge 
whether current element is equal to the previous one.
Number counting is the same as 90. Subsets II where we count the number at the beginning of each round 
of traversal.

Reference: https://leetcode.com/problems/letter-tile-possibilities/solutions/308323/java-1ms-simple-solution-which-combines-permutation-and-subset/?orderBy=most_votes
*/

import java.util.*;

public class LetterTilePossibilities {
    int count;

    public int numTilePossibilities(String tiles) {
        count = 0;
        char[] tilesArr = tiles.toCharArray();
        boolean[] visited = new boolean[tilesArr.length];
        Arrays.sort(tilesArr);
        dfs(tilesArr, visited);
        return count - 1;
    }

    private void dfs(char[] tilesArr, boolean[] visited) {
        count++;
        for (int i = 0; i < tilesArr.length; i++) {
            if (visited[i] || i > 0 && tilesArr[i] == tilesArr[i - 1] && !visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            dfs(tilesArr, visited);
            visited[i] = false;
        }
    }
}
