/*
Problem:
You are given a positive integer n.

Continuously replace n with the sum of its prime factors.

Note that if a prime factor divides n multiple times, it should be included in the sum as many times as it divides n.
Return the smallest value n will take on.

Link: https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/description/

Solution:
The idea of this solution relies on the fact that a number is not less than the sum of its primes. 
Equality is attained for the prime numbers themselves and also for the number 4. Thus we can iteratively 
decompose n into primes and compute their sum until the sequence stabilizes.

Reference:
1. https://leetcode.com/problems/smallest-value-after-replacing-with-sum-of-prime-factors/solutions/2923506/python-prime-factorization-explained/?orderBy=most_votes
*/

public class SmallestValueAfterReplacingWithSumOfPrimeFactors {
    public int smallestValue(int n) {
        int smallestNum = n;
        while (true) {
            smallestNum = sumOfPrimeFactors(smallestNum);
            if (smallestNum == n) {
                break;
            }
            n = smallestNum;
        }

        return smallestNum;
    }

    private int sumOfPrimeFactors(int num) {
        int sum = 0;
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                sum += i;
                num /= i;
            }
        }

        if (num > 1) {
            sum += num;
        }

        return sum;
    }
}
