/*
Problem:
We have n buildings numbered from 0 to n - 1. Each building has a number of employees. It's transfer season, 
and some employees want to change the building they reside in.

You are given an array requests where requests[i] = [fromi, toi] represents an employee's request to transfer 
from building fromi to building toi.

All buildings are full, so a list of requests is achievable only if for each building, the net change in employee 
transfers is zero. This means the number of employees leaving is equal to the number of employees moving in. For 
example if n = 3 and two employees are leaving building 0, one is leaving building 1, and one is leaving building 2, 
there should be two employees moving to building 0, one employee moving to building 1, and one employee moving to building 2.

Return the maximum number of achievable requests.

Link: https://leetcode.com/problems/maximum-number-of-achievable-transfer-requests/description/

Solution: 
* For requests to be valid, we can check the number of incoming requests and outgoing requests, which can be tracked
using an array - "inDegree".
* Now, we use backtracking to explore all possible combinations of the given set of requests.
*/

public class MaximumNumberOfAchievableTransferRequests {
    int maxRequests = 0;
    public int maximumRequests(int n, int[][] requests) {
        maximumRequests(n, requests, 0, new int[n], 0);
        return maxRequests;
    }

    private void maximumRequests(int n, int[][] requests, int idx, int[] indegree, int count) {
        if(idx == requests.length) {
            for(int inDeg : indegree) {
                if(inDeg != 0) {
                    return;
                }
            }
            maxRequests = Math.max(maxRequests, count); 
            return;
        }
        
        indegree[requests[idx][0]]--;
        indegree[requests[idx][1]]++;
        maximumRequests(n, requests, idx + 1, indegree, count + 1);
        indegree[requests[idx][0]]++;  
        indegree[requests[idx][1]]--;
        maximumRequests(n, requests, idx + 1, indegree, count);
    }    
}
