class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int left = 0; int right = n - 1; 

        while (left < right)
        {   
            int mid = (left + right)/2; 
            if (nums[mid] < nums[right]) // 1 2 3 4 5 
                right = mid; 
            else // mid > right 
                left = mid + 1; // 3 4 5 1 2 
        }

        System.out.println(left); 
        int x1 = binarySearch(nums, 0, left, target); 
        if (x1 != -1)
            return x1; 
        return binarySearch(nums, left, nums.length - 1, target); 
    }

    private int binarySearch(int[] nums, int left, int right, int target)
    {
        while (left <= right)
        {
            int mid = (left + right)/2; 
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; 
            else 
                right = mid - 1; 
        }

        return -1; 
    }
}
