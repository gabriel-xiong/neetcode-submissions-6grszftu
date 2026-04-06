class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length; 
        
        int count = 0; 
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (dfs(grid, r, c))
                    count++;

        return count; 
    }

    private boolean dfs (char[][] grid, int row, int col)
    {
        if (row >=grid.length || row < 0 || col >= grid[0].length || col < 0)
            return false; 

        if (grid[row][col] == '0')
            return false; 

        grid[row][col] = '0';
        dfs(grid, row + 1, col);
        dfs(grid, row -1 , col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col -1);

        return true; 
    }
}
