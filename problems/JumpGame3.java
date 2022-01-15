/*
Problem:
Given an array of non-negative integers arr, you are initially positioned at start index of the array. When you are at index i, 
you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
Notice that you can not jump outside of the array at any time.

Link: https://leetcode.com/problems/jump-game-iii/

Solution:
Think of the problem as a graph each node has 2 neighbours at arr[i] + i and i - arr[i]
*/

import java.util.*;

public class JumpGame3 {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);

        while (!q.isEmpty()) {
            int pos = q.poll();
            if (pos < 0 || pos >= arr.length) {
                continue;
            }

            if (arr[pos] < 0) {
                continue;
            }

            if (arr[pos] == 0) {
                return true;
            }

            q.add(arr[pos] + pos);
            q.add(pos - arr[pos]);
            arr[pos] = -arr[pos];
        }

        return false;
    }
}
