import java.io.*;
import java.lang.*;
/*
Problem:
Given a set of N jobs where each jobi has a deadline and profit associated with it.
Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only 
if the job is completed by its deadline.
Find the number of jobs done and the maximum profit.

Link: https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#

Solution: 
greedily select the jobs with the max profit and place it in the last possible deadline possible

time complexity: O(N log N) + O(N*M).
O(N log N ) for sorting the jobs in decreasing order of profit. O(N*M) since we are iterating through all N jobs and for every 
job we are checking from the last deadline, say M deadlines in the worst case.

space complexity: O(M) - for an array that keeps track on which day which job is performed if M is the maximum deadline available.
*/

import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

public class JobSequencing {
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxDeadline = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadline) {
                maxDeadline = arr[i].deadline;
            }
        }

        int[] jobSeq = new int[maxDeadline + 1];
        Arrays.fill(jobSeq, -1);

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j >= 1; j--) {
                if (jobSeq[j] == -1) {
                    jobSeq[j] = arr[i].profit;
                    break;
                }
            }
        }

        int jobCount = 0, maxProfit = 0;
        for (int i : jobSeq) {
            //System.out.print(i + " ");
            if (i != -1) {
                jobCount++;
                maxProfit += i;
            }
        }
        //System.out.println();

        return new int[] { jobCount, maxProfit };
    }
}