class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(ans, candidates, target, 0, new ArrayList<Integer>());
        return ans; 
    }

    public void backtrack(List<List<Integer>> ans, int[] candidates, 
    int target, int index, List<Integer> current)
    {  
        if (target == 0)
            {
                ans.add(new ArrayList<>(current));
                return; 
            }
        if (target < 0 || index >= candidates.length)
            return; 

        current.add(candidates[index]);
        backtrack(ans, candidates, target - candidates[index], index + 1, current);
        current.remove(current.size() -1);
        while (index < candidates.length - 1 && candidates[index] == candidates[index + 1])
            index++; 
        backtrack(ans, candidates, target, index + 1, current);
    }
}
