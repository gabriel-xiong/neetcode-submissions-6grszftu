class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num: nums)
            total+=num; 

        if (total %2 == 1)
            return false; 
        
        int half = total/2;

        boolean[] dp = new boolean[half + 1];
        dp[0] = true; 
        for (int i = 0; i < nums.length; i++)
            {
            for (int j = half; j>=nums[i]; j--)
            {
                dp[j] = dp[j] || dp[j - nums[i]];
            }
            }

        return dp[half]; 
    }
}
