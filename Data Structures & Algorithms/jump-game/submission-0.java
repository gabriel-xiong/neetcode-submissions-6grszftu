class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length; 
        boolean[] reachable = new boolean[n];

        reachable[0] = true;

        for (int i = 0; i < n; i++)
            {   if (!reachable[i])
                    continue; 
                for (int j = 1; j <=nums[i] && i+j<n; j++)
                    reachable[i+j] = true; 
            }

        System.out.println(Arrays.toString(reachable));
        return reachable[n-1]; 
    }
}
