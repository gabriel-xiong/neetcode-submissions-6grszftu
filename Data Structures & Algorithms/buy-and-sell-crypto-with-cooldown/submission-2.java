class Solution {
    public int maxProfit(int[] prices) {
        
        int days = prices.length; 
        //dp definition: dp[x][1] = max profit starting at day x
        //when we have no stock
        // dp[x][0] = max profit when we are currently holding a stock
        int[][] dp = new int[days + 1][2]; 
        Arrays.fill(dp[days], 0);

        for (int i = days - 1; i >=0; i--)
        {   
            int price = prices[i]; 
            if (i + 1 < days)
            {
                dp[i][0] = Math.max(price + dp[i+2][1], dp[i+1][0]);
                dp[i][1] = Math.max(dp[i+1][1], dp[i+1][0] - price);
            }
            else
                {dp[i][0] = price;}
        }

        return dp[0][1]; 
    }
}
