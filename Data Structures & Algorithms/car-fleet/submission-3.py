class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:

        cars = sorted(zip(position, speed), key = lambda car: car[0], reverse = True)

        stack = []
        for car in cars: 
            time = (target - car[0]) / car[1]
            if not stack:
                stack.append(time) 
            else: 
                if time > stack[-1]: 
                    stack.append(time) 
        
        return len(stack)

