class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(ans, nums, 0, new ArrayList<Integer>());
    return ans; 
    
    }

    private void backtrack(List<List<Integer>> ans, int[] nums, int len, List<Integer> curr)
    {
        if (len == nums.length)
            {
                ans.add(new ArrayList<>(curr));
                return; 
            }
        
        curr.add(nums[len]);
        backtrack(ans, nums, len+1, curr);
        curr.remove(curr.size() -1);
        backtrack(ans, nums, len+1, curr);
    }
}
