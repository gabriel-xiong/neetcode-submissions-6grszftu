class Solution {
    public int minCostClimbingStairs(int[] cost) {
        
        int stairs = cost.length; 

        int[] result = new int[stairs + 2];

        if (stairs ==1)
            return cost[0];
        if (stairs ==2)
            return Math.min(cost[0], cost[1]);

        result[1] = 0;
        result[2] = 0;

        for (int i = 3; i<=stairs+1; i++)
            result[i] = Math.min(cost[i-2] + result[i-1], cost[i-3] + result[i-2]);

        System.out.println(Arrays.toString(result));
        return result[stairs+1];

    }
}
