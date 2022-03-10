/*
Problem:
Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.

Link: https://leetcode.com/problems/pascals-triangle-ii/

Solution:
dp
*/

import java.util.*;

public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(new ArrayList<>());
        rows.get(0).add(1);
        
        if(rowIndex == 0) {
            return rows.get(0);
        }
        
        for(int i = 1; i <= rowIndex; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for(int j = 1; j < rows.get(i - 1).size(); j++) {
                row.add(rows.get(i - 1).get(j - 1) + rows.get(i - 1).get(j));
            }
            row.add(1);
            rows.add(row);
        }
        
        return rows.get(rowIndex);
    }
}