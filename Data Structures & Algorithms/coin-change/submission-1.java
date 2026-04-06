class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length; 

        int[] amounts = new int[amount + 1]; 
        for (int i = 1; i <= amount; i++)
            amounts[i] = Integer.MAX_VALUE; 

        for (int i = 0; i < n; i++)
            {
                for (int j = coins[i]; j <= amount; j++)
                    {   if (amounts[j - coins[i]] == Integer.MAX_VALUE)
                            continue; 
                        amounts[j] = Math.min(amounts[j], amounts[j - coins[i]] + 1); }
            }

        return amounts[amount] != Integer.MAX_VALUE ? amounts[amount] : -1; 
    }
}
