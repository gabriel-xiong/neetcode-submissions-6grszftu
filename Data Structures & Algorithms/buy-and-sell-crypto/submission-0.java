class Solution {
    public int maxProfit(int[] prices) {
        int left = 0; 
        int maxProfit = 0; 
        for (int r = 0; r < prices.length; r++)
        {
            if (prices[r] < prices[left])
                left = r; 
            maxProfit = Math.max(maxProfit, prices[r] - prices[left]);
        }

        return maxProfit; 
    }
}
