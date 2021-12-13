import java.util.*;

/*
Question:
Given an integer numRows, return the first numRows of Pascal's triangle.

Link: https://leetcode.com/problems/pascals-triangle/

Solution:
DP - bottom up approach
*/

public class PascalsTriangle {

    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        pascalTriangle.add(new ArrayList<Integer>());
        pascalTriangle.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            List<Integer> prevRow = pascalTriangle.get(i - 1);
            for (int j = 1; j < i; j++) {
                row.add(prevRow.get(j - 1) + prevRow.get(j));
            }
            row.add(1);

            pascalTriangle.add(row);
        }

        return pascalTriangle;
    }

    public static void main(String[] args) {
        List<List<Integer>> pascalTriangle = generate(5);
        for (List<Integer> row : pascalTriangle) {
            System.out.println(row.toString());
        }
    }
}
