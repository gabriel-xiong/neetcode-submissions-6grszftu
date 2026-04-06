class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int len1 = text1.length(); 
        int len2 = text2.length(); 

        // dp definition: dp[x][y] = longest common subsequence using
        // first x characters from text1, firsty characters from text2
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int r = 1; r <= len1; r++)
            for (int c = 1; c <= len2; c++)
            {
                char c1 = text1.charAt(r - 1); 
                char c2 = text2.charAt(c - 1); 

                if (c1 == c2){
                    dp[r][c] = dp[r-1][c-1] + 1; 
                }
                else 
                    dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);

            }

        return dp[len1][len2];
    }
}
