/*
Problem:
Given two numbers N and M, find the Nth root of M

Link: https://www.codingninjas.com/codestudio/problems/1062679?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1

Solution:
Solved nth root of a number using binary search
*/

public class NthRootofNumber {
    private double multiply(double number, int n) {
        double ans = 1.0;
        for (int i = 1; i <= n; i++) {
            ans = ans * number;
        }
        return ans;
    }

    private double getNthRoot(int n, int m) {
        double low = 1;
        double high = m;
        double eps = 1e-6;

        while ((high - low) > eps) {
            double mid = (low + high) / 2.0;
            if (multiply(mid, n) < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        System.out.println(n + "th root of " + m + " is " + low);
        return low;
    }
}
