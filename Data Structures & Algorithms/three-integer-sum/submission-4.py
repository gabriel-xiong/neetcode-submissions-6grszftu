class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        ans = []
        for index in range (len(nums)): 
            if index > 0 and nums[index] == nums[index -1]:
                continue 
            
            left = index + 1 
            right = len(nums) - 1 
            while left < right: 
                sum = nums[index] + nums[left] + nums[right]
                if sum == 0: 
                    ans.append([nums[index], nums[left], nums[right]])
                    left += 1
                    right -= 1
                    while nums[left] == nums[left - 1] and left < right: 
                        left +=1 
                    while nums[right] == nums[right + 1] and left < right: 
                        right -=1 
                elif sum < 0: 
                    left += 1
                else:
                    right -= 1

        return ans 