class Solution {
    public int orangesRotting(int[][] grid) {
        
        Deque<int[]>queue = new ArrayDeque<>();
        int freshOranges = 0; 
        int time = 0; 

        for (int r= 0; r<grid.length; r++)
            for (int c = 0; c<grid[0].length; c++)
                {
                    if (grid[r][c] == 2)
                        queue.offer(new int[]{r, c});
                    else if (grid[r][c] == 1)
                        freshOranges++; 
                }

        int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0,-1}};
        while (freshOranges > 0 && !queue.isEmpty())
        {   
            int length = queue.size(); 
            for (int i = 0; i < length; i++)
                {
                    int[] curr = queue.poll(); 
                    System.out.println(Arrays.toString(curr));
                    for (int[] dir : directions)
                        {
                            int newRow = curr[0] + dir[0]; 
                            int newCol = curr[1] + dir[1];

                            if (newRow >=0 && newRow < grid.length && newCol >=0 && newCol < grid[0].length && grid[newRow][newCol] == 1)
                                {   grid[newRow][newCol] = 2; 
                                    freshOranges--;
                                    queue.offer(new int[]{newRow, newCol});
                                }
                        }

                    
                }

            time++; 
        }
        
        System.out.println(freshOranges);

        if (freshOranges == 0)
            return time; 
        else 
            return -1; 
    }
}
