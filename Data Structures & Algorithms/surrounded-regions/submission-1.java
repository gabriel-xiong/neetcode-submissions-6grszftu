class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length; 

        for (int r = 0 ; r < rows; r++)
            for (int c =0 ; c < cols; c++)
            {
                if (!(r == 0 || r == rows - 1 || c ==0 || c == cols -1) || 
                    board[r][c] != 'O')
                    continue; 
                dfs(board, r, c);
            }

        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
            {
                if (board[r][c] == 'O')
                    board[r][c] = 'X';
                else if (board[r][c] == '#')
                    board[r][c] = 'O';
            }

       
    }

    private void dfs(char[][] board, int row, int col)
    {
        if (row < 0 || row >= board.length || col < 0 || col >=board[0].length || 
        board[row][col] != 'O')
            return; 

        board[row][col] = '#';
        dfs(board, row + 1, col);
        dfs(board, row - 1, col);
        dfs(board, row, col + 1);
        dfs(board, row, col -1);

        
    }
}
