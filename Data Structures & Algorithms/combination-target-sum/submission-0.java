class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, target, 0, 0, new ArrayList<>());
        return ans;  
    }

    static void backtrack(List<List<Integer>> ans, int[] nums, int target, int index, int sum, List<Integer> curr)
    {   System.out.println(sum);
        if (target == sum)
            {
                ans.add(new ArrayList<>(curr));
                return; 
            }
        
        if (sum > target || index == nums.length)
            return ;
        
        curr.add(nums[index]);
        backtrack(ans, nums, target, index, sum + nums[index], curr);
        curr.remove(curr.size() -1);
        backtrack(ans, nums, target, index + 1, sum, curr);
    }
}
