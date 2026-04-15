class Solution {
    public int search(int[] nums, int target) {
        int left = 0; 
        int right = nums.length - 1; 

        // rationale: identify which half is sorted, so we can safely discard one of the halves
        // because we can feasibly check if the target is in that range 
        while (left <= right)
        {
            int mid = left + (right - left)/2; 
            if (nums[mid] == target)
                return mid; 
            
            if (nums[left] <= nums[mid]) // left side sorted. e.g 1, 2, 3, 4, 5 
            {
                if (nums[left] <= target && target < nums[mid]) // target is in this half  
                    right = mid -1; 
                else 
                    left = mid + 1; // target in right half 
            }
            else
            {
                if (nums[mid] < target && target <= nums[right]) // target is in this hafl
                    left = mid + 1; 
                else 
                    right = mid - 1; 
            }
        }

        return -1; 
    }
}
