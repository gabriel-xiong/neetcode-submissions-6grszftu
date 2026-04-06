class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<int[]>(); 
        int rows = grid.length; 
        int cols = grid[0].length; 

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (grid[r][c] == 0)
                    queue.add(new int[]{r, c});

        if (queue.size() == 0)
            return; 

        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!queue.isEmpty())
        {
            int[] node = queue.poll(); 
            int r = node[0]; int c = node[1]; 

            for (int[] dir1 : dir)
                {
                    int row = r + dir1[0]; int col = c + dir1[1];
                    if (row < 0 || col < 0 || row >=rows || col >=cols || grid[row][col] != 2147483647)
                continue; 
                    queue.add(new int[] {row, col});
                    grid[row][col] = grid[r][c] + 1; 
                }
            
            
          

            

        }
    }
}
