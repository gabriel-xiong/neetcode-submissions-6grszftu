class Solution {
    public int search(int[] nums, int target) {

    int left = 0; int right = nums.length - 1; 

    while (left < right)
    {
        int mid = left + (right - left)/2; 

        if (nums[mid] > nums[right])
            left = mid + 1; 
        else 
            right = mid; 
    }

    System.out.print("pivot "+ left);
    int pos = binarySearch(nums, target, left, nums.length-1);
    if (pos !=-1)
        return pos; 
     pos = binarySearch(nums, target, 0, left - 1);
        return pos; 
            
    }

    static int binarySearch(int[] nums, int target, int left, int right)
        {
            while (left <= right)
                {
                    int mid = left + (right - left)/2; 
                    if (nums[mid] == target)
                        return mid;
                    else if (nums[mid] > target)
                        right = mid - 1; 
                    else 
                        left = mid + 1; 
                }

            return -1; 
        }
}
