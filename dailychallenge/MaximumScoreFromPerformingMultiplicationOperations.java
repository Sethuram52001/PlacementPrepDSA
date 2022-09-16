/*
Problem:
You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.

You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:

Choose one integer x from either the start or the end of the array nums.
Add multipliers[i] * x to your score.
Remove x from the array nums.
Return the maximum score after performing m operations.

Link: https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/

Solution:
Dynamic Programming. Select best from all possible states and instead of computing again and again, save what you have 
already computed. Memoizing the pre-visited states while trying all the possible scenarios will reduce the complexity.

To determine a state, we essentially need 3 things
i. left: specify we have used left integers from the left side of nums so far. Next, we may use nums[left]

ii. right: specify we have used right integers from the right side of nums so far. Next, we may use nums[right]

iii. op: number of operations done.

Hence, there are 3 state variables, left, right, and op. Thus, it's a 3D Dynamic Programming problem. And to memoize it, we may need a 3D array.
If there are n state variables, then we need an array of at most n dimensions.However, with mathematics, we can reduce these 3 state variables to 2.

Therefore, we can define a state with only two state variables op and left. We will use dp to denote the state in the following.
dp[op][left] stores the maximum possible score after we have done op total operations and used left numbers from the left/start side.

From this state, we have two options
i. Select Left: Number of operations will advance by one. And, so does the left pointer. Thus, we will multiply mulitpliers[op] and 
nums[left] (since we have selected from left), and add this product to (optimal) result of state dp[op+1][left+1].

ii. Select Right: Then also the number of operations will advance by one. Then, we will multiply mulitpliers[op] with 
nums[n-1-(op-left)] (since we have selected from right), and add this product to (optimal) result of state dp[op+1][left] 
(Now, left will not increment since number has not been chosen from left).

Select maximum of results obtained by selecting from Left, and Right.
If op == m, means we have performed m operations, add 0. The base Condition of Recursion.
*/

public class MaximumScoreFromPerformingMultiplicationOperations {
    public int maximumScore(int[] nums, int[] multipliers) {
        Integer[][] memo = new Integer[multipliers.length + 1][nums.length + 1];
        return maximumScore(nums, multipliers, memo, 0, 0);
    }
    
    private int maximumScore(int[] nums, int[] multipliers, Integer[][] memo, int op, int left) {
        int n = nums.length;
        if(op >= multipliers.length) {
            return 0;
        }
        
        if(memo[op][left] != null) {
            return memo[op][left];
        }
        
        int leftScore = nums[left]*multipliers[op] + maximumScore(nums, multipliers, memo, op + 1, left + 1);
        int rightScore = nums[n - 1 - (op - left)]*multipliers[op] + maximumScore(nums, multipliers, memo, op + 1, left);
        return memo[op][left] = Math.max(leftScore, rightScore);
    }
}
