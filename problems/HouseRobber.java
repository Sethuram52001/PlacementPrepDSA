public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int prev1 = 0, prev2 = 0;
        for (int num : nums) {
            int temp = prev1;
            prev1 = Math.max(prev2 + num, prev1);
            prev2 = temp;
        }

        return prev1;
    }
    
    public int robDP(int[] nums) {
        int n = nums.length;
        int[] memo = new int[n + 1];
        memo[1] = nums[0];
        
        for(int i = 1; i < n; i++) {
            int val = nums[i];
            memo[i + 1] = Math.max(val + memo[i - 1], memo[i]);
        }
        
        return memo[n];
    }   
}