/*
Problem:
You have n flower seeds. Every seed must be planted first before it can begin to grow, then bloom. 
Planting a seed takes time and so does the growth of a seed. You are given two 0-indexed integer 
arrays plantTime and growTime, of length n each:

plantTime[i] is the number of full days it takes you to plant the ith seed. Every day, you can work 
on planting exactly one seed. You do not have to work on planting the same seed on consecutive days, 
but the planting of a seed is not complete until you have worked plantTime[i] days on planting it in total.
growTime[i] is the number of full days it takes the ith seed to grow after being completely planted. 
After the last day of its growth, the flower blooms and stays bloomed forever.
From the beginning of day 0, you can plant the seeds in any order.

Return the earliest possible day where all seeds are blooming.

Link: https://leetcode.com/problems/earliest-possible-day-of-full-bloom/

Solution:
We can benefit from by first planting the plant which takes the most time to grow, as during that
time we can plant all other plants. So, we can sort the plants based on the growing times, so now all that
matters is the planting time, which accounts for days which takes for a full blossom.
*/

import java.util.*;
import javafx.util.Pair;

public class EarliestPossibleDayOfFullBloom {
    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (int idx = 0; idx < plantTime.length; idx++) {
            pq.add(new Pair<Integer, Integer>(plantTime[idx], growTime[idx]));
        }

        int days = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> plant = pq.remove();
            days = Math.max(days, plant.getValue());
            days += plant.getKey();
        }

        return days;
    }
}
