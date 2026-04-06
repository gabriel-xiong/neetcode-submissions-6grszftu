class Solution {
    public int numIslands(char[][] grid) {
        int count = 0 ; 
        int rows = grid.length; int cols = grid[0].length; 

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (dfs(r, c, grid))
                    count++; 
        return count; 
    }

    public boolean dfs(int row, int col, char[][] grid)
    {   int rows = grid.length; int cols = grid[0].length;
        if (row < 0 || row >= rows || col < 0 || col >=cols || grid[row][col] != '1' )
            return false; 
        
        grid[row][col] = '0';
        dfs(row+1, col, grid);
        dfs(row-1, col, grid);
        dfs(row, col+1, grid);
        dfs(row, col-1, grid);

        return true; 
    }
}
