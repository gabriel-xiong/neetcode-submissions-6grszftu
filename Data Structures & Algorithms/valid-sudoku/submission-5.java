class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        for (int r = 0; r < 9; r++)
        {   Set<Character> rowSet = new HashSet<Character>();
            for(int c1 = 0; c1 < 9; c1++)
            {
                char c = board[r][c1]; 
             if (c=='.')
                continue; 
            if (!rowSet.add(c))
                return false; 
            }
        }

        for (int c = 0; c < 9; c++)
        {  Set<Character> colSet = new HashSet<Character>();
            for (int r = 0; r < 9; r++)
            {
                char k = board[r][c]; 
            if (k=='.')
                continue; 
            if (!colSet.add(k))
                return false; 
            }
        }

        for (int r = 0; r < 3; r++)
            for (int c = 0; c<3; c++)
            {  Set<Character> boardSet = new HashSet<Character>();

                int startRow = 3*r; 
                int startCol = 3*c; 

            for (int r1 = 0; r1 < 3; r1++)
                for (int c1= 0; c1<3; c1++)
            {
                char k = board[startRow+r1][startCol + c1]; 
             if (k=='.')
                continue; 
            if (!boardSet.add(k))
                return false; 
            }

            }


        return true; 

    }
}
