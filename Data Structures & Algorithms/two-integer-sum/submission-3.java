class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean found = false; 
        int i = 0;
        while (!found)
        {
            int diff = target - nums[i];
            if (map.containsKey(diff))
                {
                    int[] sol = new int[2];
                    sol[0] = map.get(diff);
                    sol[1] = i;

                    return sol; 
                }
            else 
                {
                    map.put(nums[i], i);
                    i++;
                }
        }

        return null;




      
    }
}
