class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        minNum = self.getMin(nums)
        #print(minNum)
        ans1 = self.binary_search(nums[:minNum], target)
        print("ans1", ans1) 
        if ans1 != -1:
            return ans1
        ans2 = self.binary_search(nums[minNum:], target)
        print("ans2", ans2)
        if ans2 != -1:
            return minNum + ans2
        return -1 

    def getMin(self, nums: List[int]) -> int: 
        lo = 0 
        hi = len(nums) - 1

        while lo < hi: 
            mid = (lo + hi) // 2
            num = nums[mid]

            if num < nums[hi]: 
                hi = mid 
            else: 
                lo = mid + 1 

        return lo

    def binary_search(self, nums, target):
        lo, hi = 0, len(nums) - 1

        while lo <= hi:
            mid = (lo + hi) // 2

            if nums[mid] == target:
                return mid
            elif nums[mid] < target:
                lo = mid + 1
            else:
                hi = mid - 1

        return -1