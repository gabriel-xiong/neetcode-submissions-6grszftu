class Solution {
    public int maxProduct(int[] nums) {
        int min = nums[0]; 
        int max = nums[0]; 
        int globalMax = nums[0]; 

        for (int i = 1; i < nums.length; i++)
        {   int num = nums[i];
            int[] minMax = getMinMax(num, min * num, max*num);
            min = minMax[0]; 
            max = minMax[1];
            globalMax = Math.max(globalMax, max);
        }

        return globalMax; 
    }

    private int[] getMinMax(int a, int b, int c)
    {
        int max = Math.max(a,b); 
        max = Math.max(max,c); 

        int min = Math.min(a,b);
        min = Math.min(min, c); 

        return new int[] {min, max};

    }
}
