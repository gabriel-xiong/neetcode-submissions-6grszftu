class Solution {
    public int jump(int[] nums) {
        int left = 0; int right = 0; 
        int steps = 0; 

        while (right < nums.length - 1)
        {   System.out.println("left " + left + "right " + right);
            steps++; 
            int newRight = right; 
            for (int i = left; i <= right; i++)
            {
                newRight = Math.max(newRight, i + nums[i]);   
            }
            left = right + 1; 
            right = newRight; 
        }

        return steps; 
    }
}
