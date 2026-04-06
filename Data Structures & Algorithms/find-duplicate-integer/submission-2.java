class Solution {
    public int findDuplicate(int[] nums) {

        for (int x : nums)
        {
            int index = Math.abs(x) - 1; 
            if (nums[index] < 0)
                return Math.abs(x); 
            
            nums[index]*= -1; 
        }

        return 0; 
    }
}
