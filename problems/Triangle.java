/*
Problem:
Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on 
index i on the current row, you may move to either index i or index i + 1 on the next row.

Link: https://leetcode.com/problems/triangle/

Solution:
DP - visualize from bottom up taking min path from the leaf node levels(but not a tree problem though just for
easier visualization)
*/

import java.util.*;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1; i >= 0; i--) {
            for(int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
