class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length; 

        int max = 0; 
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                if (grid[r][c] == 1)
                    max = Math.max(max, dfs(grid, r, c)); 
            }
        }

        return max; 
    }

    private int dfs (int[][] grid, int row, int col)
    {   int area = 1; 
        if (row < 0 || row >= grid.length || col < 0 || col >=grid[0].length || grid[row][col] == 0)
            return 0; 
        grid[row][col] = 0; 
        area += dfs(grid, row + 1, col); 
        area += dfs(grid, row - 1, col); 
        area += dfs(grid, row, col + 1); 
        area += dfs(grid, row, col - 1); 

        return area; 
    }
}


