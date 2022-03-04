/*
Problem:
We stack glasses in a pyramid, where the first row has 1 glass, the second row has 2 glasses, and so on until the 100th row.  
Each glass holds one cup of champagne.

Then, some champagne is poured into the first glass at the top.  When the topmost glass is full, any excess liquid poured 
will fall equally to the glass immediately to the left and right of it.  When those glasses become full, any excess champagne will 
fall equally to the left and right of those glasses, and so on.  (A glass at the bottom row has its excess champagne fall on the floor.)

Now after pouring some non-negative integer cups of champagne, return how full the jth glass in the ith row is (both i and j are 0-indexed.)

Link: https://leetcode.com/problems/champagne-tower/

Solution:
Simulation
*/

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] champagneTower = new double[102][102];
        champagneTower[0][0] = poured;
        
        for(int r = 0; r <= query_row; r++) {
            for(int c = 0; c <= r; c++) {
                double excess = (champagneTower[r][c] - 1.0)/2;
                if(excess > 0) {
                    champagneTower[r + 1][c] += excess;
                    champagneTower[r + 1][c + 1] += excess;
                }
            }
        }
        
        return Math.min(1, champagneTower[query_row][query_glass]);
    }
}
