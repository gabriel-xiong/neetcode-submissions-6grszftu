class Solution:
    def findMin(self, nums: List[int]) -> int:
        # 1 2 3 | 4 5 6 m < r --> sorted, so min is in left half; retain middle element 
        # 2 3 4 | 5 6 1 m > r --> unsorted, so min is in the right half 

        lo = 0 
        hi = len(nums) - 1

        while lo < hi: 
            mid = (lo + hi) // 2
            num = nums[mid]

            if num < nums[hi]: 
                hi = mid 
            else: 
                lo = mid + 1 

        return nums[lo]  