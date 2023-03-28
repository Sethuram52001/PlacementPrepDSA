/*
Problem:
You have planned some train traveling one year in advance. The days of the year in which you will travel are given as an integer array days. Each day is an integer from 1 to 365.

Train tickets are sold in three different ways:

a 1-day pass is sold for costs[0] dollars,
a 7-day pass is sold for costs[1] dollars, and
a 30-day pass is sold for costs[2] dollars.
The passes allow that many days of consecutive travel.

For example, if we get a 7-day pass on day 2, then we can travel for 7 days: 2, 3, 4, 5, 6, 7, and 8.
Return the minimum number of dollars you need to travel every day in the given list of days.

Link: https://leetcode.com/problems/minimum-cost-for-tickets/description/

Solution:
DP: consider minimum cost using cost1(1 day), cost2(7 days), cost3(30 days)
*/

public class MinimumCostForTickets {
        public int mincostTickets(int[] days, int[] costs) {
        int lastTravelDay = days[days.length -1];
        int[] dp = new int[lastTravelDay + 1];
        boolean[] travelDays = new boolean[lastTravelDay + 1];
        for(int day: days) {
            travelDays[day] = true;
        }

        for(int i = 1; i <= lastTravelDay; i++) {
            if(!travelDays[i]) {
                dp[i] = dp[i - 1];
                continue;
            }

            dp[i] = costs[0] + dp[i - 1];
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 7)] + costs[1]);
            dp[i] = Math.min(dp[i], dp[Math.max(0, i - 30)] + costs[2]);
        }

        return dp[lastTravelDay];
    }
}
