/*
Problem:
There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the ith station to its next (i + 1)th station. 
You begin the journey with an empty tank at one of the gas stations.

Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the 
clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique

Link: https://leetcode.com/problems/gas-station/

Solution:
The algorithm - circular tour

We can say that there must be a soln if and only if sum(gas[i] - cost[i]) >= 0.
We can traverse from each point and check for this condition to be true or not, we can mainted coveredPath variable where we 
add the gasInTank when it is negative so that we don't need to traverse those points once again instead we can use that value to check
*/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasInTank = 0, coveredPath = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            gasInTank += gas[i] - cost[i];
            if (gasInTank < 0) {
                coveredPath += gasInTank;
                gasInTank = 0;
                start = i + 1;
            }
        }

        return coveredPath + gasInTank >= 0 ? start : -1;
    }
}
