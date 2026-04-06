class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length;
        int ans = 0; 
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (grid[r][c] == 1)
                    ans = Math.max(ans, dfs(grid, r, c)); 

        return ans; 
    }

    private int dfs (int[][] grid, int row, int col)
    {
        if (row >= grid.length || row < 0 || col < 0 || col >=grid[0].length || grid[row][col] == 0)
            return 0; 

        grid[row][col] = 0; 
        int area = 1; 
        area += dfs(grid, row + 1, col);
        area +=dfs(grid, row - 1, col);
        area +=dfs(grid, row, col + 1);
        area +=dfs(grid, row, col - 1);

        return area;
    }
}
