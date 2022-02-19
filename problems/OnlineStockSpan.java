/*
Problem:
Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for 
which the stock price was less than or equal to today's price.

Link: https://leetcode.com/problems/online-stock-span/

Solution:
We can use the stack to maintain the pair(day, price) in a decreasing fashion such that we can find the previous greater element.
It is similar to the stock span problem except for the part we have to track the day and prices too.

Note:
* An online algorithm is one that can process its input piece-by-piece in a serial fashion, i.e., in the order that the input is
  fed to the algorithm, without having the entire input available from the beginning.

* In contrast, an offline algorithm is given the whole problem data from the beginning and is required to output an answer which solves 
  the problem at hand.
*/

import java.util.*;

public class OnlineStockSpan {
    class StockSpanner {
        Stack<int[]> st;
        int days;

        public StockSpanner() {
            st = new Stack<>();
            days = -1;
        }
        
        public int next(int price) {
            days++;
            int span = 0;
            
            while(!st.isEmpty() && st.peek()[1] <= price) {
                st.pop();
            }
            
            if(st.isEmpty()) {
                span = days + 1; 
            }
            else {
                span = days - st.peek()[0];
            }
            
            st.push(new int[]{days, price});
            return span;
        }
    }
}