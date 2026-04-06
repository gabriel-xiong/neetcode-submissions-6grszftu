class Solution {
    public int missingNumber(int[] nums) {
        
        int ans = 0; 

        for (int num : nums)
            ans += num;

        return nums.length * (nums.length + 1)/2 - ans;
    }
}
