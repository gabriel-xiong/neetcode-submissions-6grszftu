class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        stack = [] 
        ans = [0] * len(temperatures)
        for i, x in enumerate(temperatures): 
            if not stack: 
                stack.append((x, i))
            else:  
                while stack and x > stack[-1][0]: # we have a warmer temperature 
                    prev = stack.pop()
                    ans[prev[1]] = i - prev[1]
                stack.append((x, i))
        
        return ans 
