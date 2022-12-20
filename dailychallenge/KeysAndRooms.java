/*
Problem:
There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all 
the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room 
it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can
visit all the rooms, or false otherwise.

Link: https://leetcode.com/problems/keys-and-rooms/description/

Solution:
Use DFS or BFS to explore all existing possibilities then check if all rooms are visited or not.
*/

import java.util.*;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;

        while (!st.isEmpty()) {
            int currRoom = st.pop();
            for (int key : rooms.get(currRoom)) {
                if (!visited[key]) {
                    visited[key] = true;
                    st.push(key);
                }
            }
        }

        for (boolean visitedRoom : visited) {
            if (!visitedRoom) {
                return false;
            }
        }

        return true;
    }
}
