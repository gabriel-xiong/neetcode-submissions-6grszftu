class Solution {

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num: nums)
            total+=num; 

        if (total %2 == 1)
            return false; 
        
        int half = total/2;

        //dp: can we make sum t with the first n numbers 
        boolean[][] dp = new boolean[half + 1][nums.length + 1];
        Arrays.fill(dp[0], true); 

        for (int sum = 1; sum <= half; sum++)
        {
            for (int n = 1; n <= nums.length; n++)
            {
                if (nums[n - 1] <= sum)
                {
                    dp[sum][n] = dp[sum - nums[n-1]][n-1] || dp[sum][n-1];
                }
                else
                    dp[sum][n] = dp[sum][n-1];
            }
        }

        return dp[total/2][nums.length];
    }
}
