class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int stairs = cost.length; 
        int[] costs = new int[stairs + 1];

        costs[0] = 0;
        costs[1] = 0;

        for (int i = 2; i <= stairs; i++)
            costs[i] = Math.min(costs[i-2] + cost[i-2], costs[i-1] + cost[i-1]);

        return costs[stairs];
    }
}
