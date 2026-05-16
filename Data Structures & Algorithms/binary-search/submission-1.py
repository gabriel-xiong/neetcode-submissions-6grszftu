class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l = 0
        r = len(nums) - 1
        while l <= r: 
            mid = l + (r - l) // 2
            num = nums[mid]
            if target == num:
                return mid 
            elif target > num: 
                l = mid + 1 
            else: 
                r = mid - 1

        return -1 