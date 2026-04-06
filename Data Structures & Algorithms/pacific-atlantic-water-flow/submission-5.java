class Solution {
    int[][] directions = new int[][] {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length; 
        int cols = heights[0].length; 

        Set<List<Integer>> atlantic = new HashSet<>();
        Set<List<Integer>> pacific = new HashSet<>(); 
        boolean[][] visited1 = new boolean[rows][cols]; 
        boolean[][] visited2= new boolean[rows][cols];
        for (int r = 0; r < rows; r++)
            dfs(atlantic, r, 0, visited1, heights);
        
        for (int c =0; c < cols; c++)
            dfs(atlantic, 0, c, visited1, heights);

    
        for (int r = 0; r < rows; r++)
            dfs(pacific, r, cols - 1, visited2, heights); 

        for (int c = 0; c < cols; c++)
            dfs(pacific, rows -1, c, visited2, heights); 

        

        atlantic.retainAll(pacific); 

        List<List<Integer>> ans = new ArrayList<>(); 
        ans.addAll(atlantic);

        return ans; 
    }

    private void dfs(Set<List<Integer>> ocean, int row, int col, 
    boolean[][] visited, int[][] heights)
    {   
        visited[row][col] = true; 
        ocean.add(new ArrayList<Integer>(Arrays.asList(row, col)));
        for (int[] dir: directions)
        {
            int newRow = row + dir[0]; int newCol = col + dir[1]; 
            if (newRow < 0 || newCol < 0 || newRow >=heights.length || 
            newCol >= heights[0].length || heights[newRow][newCol] < heights[row][col] ||
            visited[newRow][newCol])
                continue; 

            dfs(ocean, newRow, newCol, visited, heights);
        }

       // visited[row][col] = false;

    }
}
