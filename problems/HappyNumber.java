/*
Problem:
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.


Link: https://leetcode.com/problems/happy-number/

Solution:
We can avoid infinite loop by cycle detection, which can be implemented via a simple hashset
or floyd and tortoise algorithm. 
*/

public class HappyNumber {
    public boolean isHappy(int n) {
        int slowRunner = n;
        int fastRunner = next(n);
        
        while(fastRunner != 1 && slowRunner != fastRunner) {
            slowRunner = next(slowRunner);
            fastRunner = next(next(fastRunner));
        }
        
        return fastRunner == 1;
    }
    
    private int next(int n) {
        int next = 0;
        while (n != 0) {
            next += (int) Math.pow((n % 10), 2);
            n /= 10;
        }
        return next;
    }

    public boolean isHappy_ExtraSpace(int n) {
        HashSet<Integer> seen = new HashSet<>();
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = next(n);
        }
        return n == 1;
    }
}