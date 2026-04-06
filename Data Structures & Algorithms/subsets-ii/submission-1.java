class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(); 
        Arrays.sort(nums);    
        backtrack(nums, ans, 0, 0, new ArrayList<Integer>());
        return ans; 
    }

    private void backtrack(int[] nums, List<List<Integer>> ans, 
    int len, int index, List<Integer> current)
    {
        if (len == nums.length)
        {
            ans.add(new ArrayList<>(current));
            return; 
        }

        if (index >= nums.length)
            return; 

        current.add(nums[index]);
        backtrack(nums, ans, index + 1, len + 1, current);
        current.remove(current.size() - 1);
        int temp = index; 
        while (index + 1 < nums.length && nums[index]== nums[index + 1])
            index++;
        backtrack(nums, ans, index + 1, len + index - temp + 1, current);
    }
}
