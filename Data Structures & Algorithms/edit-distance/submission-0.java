class Solution {
    public int minDistance(String word1, String word2) {
        return dfs(word1, word2, 0, 0);
    }

    private int dfs(String word1, String word2, int i, int j)
    {
        if (i == word1.length() && j == word2.length())
            return 0; 

        if (i == word1.length())
            return 1 + dfs(word1, word2, i, j+1); 
        
        if (j == word2.length())
            return 1 + dfs(word1, word2, i + 1, j);

        
        if (word1.charAt(i) == word2.charAt(j))
            return dfs(word1, word2, i + 1, j + 1);

        int min1 = Math.min(dfs(word1, word2, i + 1, j), 
        dfs(word1, word2, i, j+1));

        return 1 + Math.min(min1, dfs(word1, word2, i+1, j+1));
        

    }
}
