/*
Given an array of integers arr, you are initially positioned at the first index of the array.

In one step you can jump from index i to index:

i + 1 where: i + 1 < arr.length.
i - 1 where: i - 1 >= 0.
j where: arr[i] == arr[j] and i != j.
Return the minimum number of steps to reach the last index of the array.

Notice that you can not jump outside of the array at any time.


Link:  https://leetcode.com/problems/jump-game-iv/

Solution:
think the problem as a graph and solve it
*/
import java.util.*;

public class JumpGame4 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> indicesOfSameValue = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!indicesOfSameValue.containsKey(arr[i])) {
                indicesOfSameValue.put(arr[i], new ArrayList<>());
            }
            indicesOfSameValue.get(arr[i]).add(i);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        int jumps = 0;
        while (!queue.isEmpty()) {
            for (int size = queue.size(); size > 0; size--) {
                int curr = queue.poll();

                if (curr == n - 1) {
                    return jumps;
                }

                List<Integer> neighbours = indicesOfSameValue.get(arr[curr]);
                neighbours.add(curr - 1);
                neighbours.add(curr + 1);

                for (int j : neighbours) {
                    if (j >= 0 && j < n && !visited[j]) {
                        visited[j] = true;
                        queue.offer(j);
                        ;
                    }
                }
                neighbours.clear();
            }
            jumps++;
        }

        return -1;
    }
}
