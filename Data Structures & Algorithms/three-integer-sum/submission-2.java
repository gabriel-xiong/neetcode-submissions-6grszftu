class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); 
        
        List<List<Integer>> sol = new ArrayList<>();
        if (nums.length < 3)
            return sol;

        for (int left = 0; left < nums.length - 2; left++ )
            {   if (left !=0 && nums[left] == nums[left-1])
                    continue; 

                int middle = left + 1; 
                int right = nums.length - 1; 

                while (middle < right)
                {
                
                int sum = nums[left] + nums[middle] + nums[right];
                if (sum == 0)
                    {
                        sol.add(Arrays.asList(nums[left], nums[middle], nums[right]));
                        middle++;
                        right--; 
                        while (middle <= nums.length - 2 && nums[middle] == nums[middle-1])
                            middle++; 
                        while (right >=1 && nums[right] == nums[right+1])
                            right--;

                    }
                else if (sum > 0)
                    {   right--;
                        
                    }
                else 
                    {
                        middle++; 
                        
                    }
                
                }
                
            }
        return sol; 
        // skip if we have a duplicate 
    }
}
