class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int rows = grid.length; 
        int cols = grid[0].length; 
        int INF = 2147483647;
        int[][] dirs = new int[][] {{0, 1}, {0, -1},{1,0}, {-1, 0}};
        Deque<int[]> queue = new ArrayDeque<>(); 
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                if (grid[r][c] == 0)
                    queue.offer(new int[] {r,c});

        while (!queue.isEmpty())
        {
            int size = queue.size(); 

            for (int i = 0; i < size; i++)
            {
                int[] coords = queue.poll(); 
                int x = coords[0]; int y = coords[1];
                int val = grid[x][y]; 
                for (int[] dir : dirs)
                {
                    int newX = x + dir[0]; int newY = y + dir[1];
                    if (newX >=0 && newX < rows && newY >=0 && newY <cols &&
                    grid[newX][newY] == INF)
                    {
                        grid[newX][newY] = val + 1; 
                        queue.offer(new int[] {newX, newY});
                    }
                }
            }
        }

       // return grid; 


    }
}
