class Solution {
    public int maxArea(int[] heights) {
        int left = 0; 
        int right = heights.length - 1; 
        int max = 0; 
        while (left < right)
        {   int gap = right - left; 
            max = Math.max(max, gap*Math.min(heights[left], heights[right]));
            if (heights[left] <= heights[right])
                left++;
            else 
                right--;
        }

        return max; 
    }

   
}
