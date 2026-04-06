class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] amounts = new int[amount + 1];
        Arrays.fill(amounts, amount + 1);
        amounts[0] = 0; 

        for (int i = 1; i <= amount; i++)
            for (int j = 0; j<coins.length; j++)
                {
                    if (coins[j] <=i)
                        amounts[i] = Math.min(amounts[i], amounts[i- coins[j]] +1);
                }

        if (amounts[amount] > amount)
            return -1; 
        return amounts[amount];
    }
}
