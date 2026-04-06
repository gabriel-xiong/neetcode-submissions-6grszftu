class Solution {
    public boolean exist(char[][] board, String word) {
        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int r = 0; r < board.length; r++ )
            for (int c = 0; c < board[0].length; c++)
                if (board[r][c] == word.charAt(0))
                    if (dfs(r, c, 0, board, word, visited))
                        return true; 
        
        return false; 
    }

    private boolean dfs(int row, int col, int len, 
    char[][] board, String word, boolean[][] visited )
    {   if (len == word.length())
            return true; 

       
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false; 
         if (visited[row][col])
            return false; 
        if (board[row][col] != word.charAt(len))
            return false; 

        visited[row][col] = true; 

        boolean valid = dfs(row + 1, col, len + 1, board, word, visited)
        || dfs(row - 1, col, len + 1, board, word, visited)
        || dfs(row , col + 1, len + 1, board, word, visited)
        || dfs(row, col - 1, len + 1, board, word, visited);

        visited[row][col] = false; 

        return valid; 
    }
}
