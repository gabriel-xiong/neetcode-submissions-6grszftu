class Solution:
    def isValidSudoku(self, board: List[List[str]]) -> bool:
        rows = defaultdict(set)
        cols = defaultdict(set) 
        boxes = defaultdict(set) 

        for row in range(9): 
            for col in range (9): 
                c = board[row][col]
                if c == '.': 
                    continue
                if (c in rows[row] or c in cols[col] or c in boxes[row // 3, col // 3]):
                    return False 
                rows[row].add(c)
                cols[col].add(c)
                boxes[row // 3, col // 3].add(c)
        
        return True 
                