class Solution {
    public int maxSubArray(int[] nums) {
        int bestSum = 0; 
        int ans = Integer.MIN_VALUE;
        for (int n : nums)
            {
                bestSum = Math.max(bestSum + n, n);
                System.out.println("n " + n + " bestSum "+ bestSum);
                ans = Math.max(bestSum, ans);
            }

        return ans; 
    }
}
