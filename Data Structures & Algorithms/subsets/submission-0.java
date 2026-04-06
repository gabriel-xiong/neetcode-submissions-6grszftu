class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        backtrack(ans, 0, nums, new ArrayList<Integer>());

        return ans; 
    }

    static void backtrack(List<List<Integer>> ans, int index, int[] nums, List<Integer> currentList)
    {   if (index >= nums.length)
            {   ans.add(new ArrayList<>(currentList));
                return;} 

        currentList.add(nums[index]);
        backtrack(ans, index+1, nums, currentList);
        currentList.remove(currentList.size() -1);
        backtrack(ans, index+1, nums, currentList);
        
    }
}
