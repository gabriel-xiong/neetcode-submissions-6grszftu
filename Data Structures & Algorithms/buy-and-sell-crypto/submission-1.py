class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        small = float("inf")
        ans = 0 
        for x in prices: 
            small = min(small, x)
            ans = max(ans, x - small)

        return ans 
