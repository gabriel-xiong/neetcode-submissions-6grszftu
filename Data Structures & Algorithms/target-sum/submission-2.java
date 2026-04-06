class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length; 
        int sum = 0; 
        for (int k: nums)
            sum+=k; 

        if (target > sum)
            return 0; 
        // dp definition: dp[x][y] = # of ways you can get sum x
        // using the first y numbers 
        int[][] dp = new int[2*sum + 1][n+1];
        dp[sum][0] = 1; 
        for (int i = 1; i <= n; i++)
        {
            for (int j = -1*sum; j <= sum; j++)
            {   
                if (dp[j + sum][i-1] == 0)
                    continue; 
                int ways = dp[j + sum][i-1]; 
                dp[j - nums[i -1] + sum][i] += ways; 
                dp[j + nums[i -1] + sum][i] += ways;  
                // remember to subtract one 
            }
        }

        return dp[target + sum][n];
    }
}
