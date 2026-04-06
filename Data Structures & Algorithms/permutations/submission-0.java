class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, nums, 0, new ArrayList<Integer>());
        return ans; 
    }

    private void backtrack(List<List<Integer>> ans, int[] nums,
    int length, List<Integer> current)
    {
        if (length == nums.length)
        {
            ans.add(new ArrayList<>(current));
            return; 
        }

        for (int x : nums)
        {
            if (current.contains(x))
                continue; 
            current.add(x); 
            backtrack(ans, nums, length +1, current);
            current.remove(current.size() - 1);
            //backtrack(ans, nums, length, current);
        }
    }
}
