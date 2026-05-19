class TimeMap:

    def __init__(self):
        self.graph = defaultdict(list)

    def set(self, key: str, value: str, timestamp: int) -> None:
        self.graph[key].append((timestamp, value))

    def get(self, key: str, timestamp: int) -> str:
        if key not in self.graph:
            return ""

        graph = self.graph[key] 
        print(graph)
        left = 0 
        right = len(graph) - 1 

        index = -1 # index needs to start at -1 
        while (left <= right):
            mid = (left + right) // 2
            time = graph[mid][0]
            if time <= timestamp: 
                index = mid 
                left = mid + 1 
            else: 
                right = mid - 1 
        
        if index == -1:
            return "" 
        return graph[index][1]
