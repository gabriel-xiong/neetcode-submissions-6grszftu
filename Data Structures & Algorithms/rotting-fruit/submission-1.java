class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0; 
        Deque<int[]> queue = new ArrayDeque<>();

        for (int r = 0; r < grid.length; r++)
            for (int c = 0; c < grid[0].length; c++)
            {
                if (grid[r][c] == 1)
                    fresh++; 
                else if (grid[r][c] == 2)
                    queue.offer(new int[] {r, c});
            }
    

    if (fresh == 0)
        return 0; 

    int time = 0; 
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    while (!queue.isEmpty())
    {
        int size = queue.size(); 
        for (int i = 0; i < size; i++)
        {
            int[] coords = queue.poll(); 
            System.out.println(Arrays.toString(coords));
            int row = coords[0]; int col = coords[1]; 
            for (int[] dir: directions)
            {
                int r = row + dir[0]; int c = col + dir[1]; 
                if (r <0 || c < 0 || r >= grid.length || c >=grid[0].length || grid[r][c] != 1)
                    continue; 
                fresh--;
                grid[r][c] = 2; 
                queue.offer(new int[] {r, c});
            }
        }
        time++; 
    }

    return fresh == 0 ? time -1 : -1;
}
}
