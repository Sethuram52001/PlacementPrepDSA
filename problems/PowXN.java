package problems;

/*
 Problem:
 Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

 Link: https://leetcode.com/problems/powx-n/

 Solution:
 We can use the fact that 4^5 = 4*4^4 = 4*16^2 ...

*/

public class PowXN {
    private static double myPow(double x, int n) {
        double ans = 1;
        long n_ = n;
        boolean isNeg = (n_ < 0) ? true : false;
        n_ = Math.abs(n_);
        
        while(n_ > 0) {
            if(n_ % 2 == 0) {
                x = x*x;
                n_ /= 2;
            }
            else {
                ans = x*ans;
                n_ --;
            }
        }
        
        if(isNeg) {
            return 1/ans;
        }
        return ans;
    }
    public static void main(String[] args) {
        double ans = myPow(2.1, 3);
        System.out.println(ans);
    }
}
