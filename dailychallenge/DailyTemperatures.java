/*
Problem:
Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] 
is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for 
which this is possible, keep answer[i] == 0 instead.

Link: https://leetcode.com/problems/daily-temperatures/

Solution:
Montonic stack
*/

import java.util.*;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int idx = 0; idx < temperatures.length; idx++) {
            while (!st.isEmpty() && temperatures[idx] > temperatures[st.peek()]) {
                int day = st.pop();
                res[day] = idx - day;
            }
            st.push(idx);
        }

        return res;
    }
}
