class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num: nums)
            total+=num; 

        if (total %2 == 1)
            return false; 
        
        return dfs(0, nums, total/2, 0); 
    }

    private boolean dfs (int index, int[] nums, int target, int sum)
    {   if (sum > target)
            return false; 
        if (sum == target)
            return true; 
        if (index >=nums.length)
            return false; 

        return dfs(index + 1, nums, target, sum) || dfs(index + 1, nums, target, sum + nums[index]);
    }
}
