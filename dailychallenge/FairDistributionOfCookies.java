/*
Problem:
You are given an integer array cookies, where cookies[i] denotes the number of cookies in the ith bag. 
You are also given an integer k that denotes the number of children to distribute all the bags of cookies to. 
All the cookies in the same bag must go to the same child and cannot be split up.

The unfairness of a distribution is defined as the maximum total cookies obtained by a single child in 
the distribution.

Return the minimum unfairness of all distributions.

Link: https://leetcode.com/problems/fair-distribution-of-cookies/description/

Solution:
* Use backtracking to explore all possible distributions.
* While, exploring all possible distributions keep track of the minimum of the maximum cookies a child gets,
which is the expected result.
*/

public class FairDistributionOfCookies {
    int minimumUnfairness = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        distributeCookies(cookies, 0, 0, new int[k]);
        return minimumUnfairness;
    }

    private void distributeCookies(int[] cookies, int idx, int maximumUnfairness, int[] children) {
        if(idx >= cookies.length) {
            minimumUnfairness = Math.min(minimumUnfairness, maximumUnfairness);
            return;
        }

        int cookie = cookies[idx];
        for(int i = 0; i < children.length; i++) {
            children[i] += cookie;
            distributeCookies(cookies, idx + 1, Math.max(children[i], maximumUnfairness), children);
            children[i] -= cookie;
        }
    }
}
