class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int prefix = 1; 
        int suffix = 1; 
        int[] prefixes = new int[n];
        int[] suffixes = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i<n; i++)
            {
                prefixes[i] = prefix; 
                prefix*=nums[i];
            }
        for (int i = n-1;i>=0; i--)
        {
            suffixes[i] = suffix; 
            suffix*=nums[i];
        }

        for (int i =0; i<n; i++)
            ans[i] = prefixes[i]*suffixes[i];
        
        return ans; 
    }
}  
