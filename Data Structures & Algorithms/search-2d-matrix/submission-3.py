class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        l = 0
        r = len(matrix) - 1
        while l <= r: 
            mid = l + (r - l) // 2
            little = matrix[mid][0]
            big = matrix[mid][-1]
            if little <= target <= big:
                break
            elif target > big: 
                l = mid + 1 
            else: 
                r = mid - 1

        if l > r: 
            return False 
        
        row = matrix[ (l+r) // 2]

        left = 0 
        right = len(row) - 1

        while left <= right: 
            mid = left + (right - left) // 2
            num = row[mid]
            if target == num:
                return True
            elif target > num: 
                left = mid + 1 
            else: 
                right = mid - 1

        return False

        