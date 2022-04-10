/*
Problem:
You are keeping score for a baseball game with strange rules. The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.

At the beginning of the game, you start with an empty record. You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:

An integer x - Record a new score of x.
"+" - Record a new score that is the sum of the previous two scores. It is guaranteed there will always be two previous scores.
"D" - Record a new score that is double the previous score. It is guaranteed there will always be a previous score.
"C" - Invalidate the previous score, removing it from the record. It is guaranteed there will always be a previous score.
Return the sum of all the scores on the record.

Link: https://leetcode.com/problems/baseball-game/

Solution:
Simulation - use a stack to simulate the game according to the rules

Note:
Deque over stack: https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack
*/

import java.util.*;

public class BaseballGame {
    public int calPoints(String[] ops) {
        Deque<Integer> records = new ArrayDeque<>();
        
        for(String op : ops) {
            if(op.equals("+")) {
                int val1 = records.pop();
                int val2 = records.peek() + val1;
                records.push(val1);
                records.push(val2);
            }
            else if(op.equals("D")) {
                records.push(records.peek()*2);
            }
            else if(op.equals("C")) {
                records.pop();
            }
            else {
                records.push(Integer.valueOf(op));
            }
        }
        
        Integer sum = 0;
        System.out.println(records.toString());
        while(!records.isEmpty()) {
            sum += records.pop();
        }
        
        return sum;
    }
}