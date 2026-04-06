class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int leftRow = 0; int rightRow = rows - 1; 

        boolean foundValidRow = false; 
        int rowFound = -1; 
        while (leftRow<=rightRow)
        {
            int mid = leftRow + rightRow >>1; 
            if (matrix[mid][0] <= target && matrix[mid][cols-1] >= target)
                {
                    foundValidRow = true; 
                    rowFound = mid; 
                    break; 
                }
            else if (matrix[mid][0] > target)
                rightRow = mid - 1; 
            else
                leftRow = mid +1; 
        }

        if (!foundValidRow)
            {   System.out.print("no valid row found");
                return false; 
            }
        
        
        int leftCol = 0; int rightCol = cols - 1; 

        int[] row = matrix[rowFound]; 

        while (leftCol <=rightCol)
        {
            int mid = leftCol + rightCol >> 1; 
            if (row[mid] == target)
                return true;
            else if (row[mid] > target)
                rightCol = mid - 1; 
            else 
                leftCol = mid + 1; 
        }

        return false; 
        
    }
}
