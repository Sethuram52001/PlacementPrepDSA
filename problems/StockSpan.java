/*
Problem:
The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of 
stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which 
the price of the stock on the current day is less than its price on the given day. 

Link: https://www.codingninjas.com/codestudio/problems/span-of-ninja-coin_1475049?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
 
Solution:
We can use a stack to maintain the value which are higher than the current stock value, we store the indices - so we can get the stock span 
by day - stack.peek().
*/

import java.util.*;

public class StockSpan {
    public static ArrayList<Integer> findSpans(ArrayList<Integer> price) {
        // Write your code here.
    	Stack<Integer> st = new Stack<>();
        ArrayList<Integer> span = new ArrayList<>();
        
        for(int i = 0; i < price.size(); i++) {
            while(!st.isEmpty() && price.get(st.peek()) <= price.get(i)) {
                st.pop();
            }
            if(st.isEmpty()) {
                span.add(i + 1);
            }
            else {
                span.add(i - st.peek());
            }
            st.push(i);
        }
        
        return span;
    }   
}