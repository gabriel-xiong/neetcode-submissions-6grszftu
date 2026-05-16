class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        maxB = 0 
        for x in piles: 
            maxB = max(maxB, x)

        lo = 1
        hi = maxB 
        ans = maxB

        while (lo <= hi): 
            speed = (lo + hi) // 2
            time = 0 
            for x in piles:
                time += (x + speed - 1) // speed

            if time <= h:
                print(speed, time)
                ans = min(ans, speed)
                hi = speed - 1
            else:
                lo = speed + 1

        return ans