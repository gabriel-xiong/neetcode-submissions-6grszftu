class Solution {
    public int maxProfit(int[] prices) {
        return dfs(prices, 0, false); 
    }

    private int dfs(int[] prices, int index, boolean haveCoin)
    {
        if (index >= prices.length)
            return 0; 
        
        if (haveCoin)
            return Math.max(dfs(prices, index + 2, false) + prices[index],
            dfs(prices, index + 1, true));

        return Math.max(dfs(prices, index + 1, true) - prices[index], 
        dfs(prices, index + 1, false));
    }
}
