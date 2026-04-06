class Solution {
    public int lengthOfLIS(int[] nums) {
        return dfs(nums, 0, 0, -1001);
    }

    private int dfs(int[] nums, int index, int counter, int prev)
    {
        if (index >=nums.length)
            return counter; 
        
        int res1 = -1; 
        if (prev == -1001 || nums[index] > prev)
        {
            res1 = dfs(nums, index + 1, counter + 1, nums[index]);
        }

        int res2 = dfs(nums, index+1, counter, prev);
        return Math.max(res1, res2); 
    }

}
