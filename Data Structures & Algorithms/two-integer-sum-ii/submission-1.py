class Solution:
    def twoSum(self, numbers: List[int], target: int) -> List[int]:
        graph = defaultdict(int)
        for i, x in enumerate(numbers): 
            diff = target - x 
            if diff in graph: 
                return [graph[diff] + 1, i + 1]
            graph[x] = i

        return []