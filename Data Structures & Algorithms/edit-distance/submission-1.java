class Solution {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length(); int len2 = word2.length(); 
        
        // dp definition: using substring starting at characters
        // i and j, how many operations would it take for equivalence?
        int[][] dp = new int[len1 + 1][len2 + 1];
        
       for (int j = 0; j <= word2.length(); j++) {
            dp[word1.length()][j] = word2.length() - j;
        }
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][word2.length()] = word1.length() - i;
        }

        for (int i = len1 - 1; i >=0; i--)
            for (int j = len2 - 1; j >=0; j--)
            {
                if (word1.charAt(i) == word2.charAt(j))
                   { dp[i][j] = dp[i + 1][j + 1]; 
                   continue;}

                int min = Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i][j] = Math.min(min, dp[i+1][j+1]) + 1;      
            } 

        return dp[0][0]; 

    }
}
