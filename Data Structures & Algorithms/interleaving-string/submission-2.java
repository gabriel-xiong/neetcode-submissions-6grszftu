class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() !=s3.length())
            return false;

        if (s3.length() == 0)
            return true; 
        
        int len1 = s1.length(); int len2 = s2.length(); 
        // dp definition: can we make the substring starting at index
        // i + j  using charcters from i onwards
        // and j onwards? 
        boolean[][] dp = new boolean[len1 + 1][len2 + 1];
        dp[0][0] = true;
        for (int i = 1; i <=len1; i++)
            dp[i][0] = (dp[i-1][0] && s1.charAt(i -1) == s3.charAt(i-1)); 
        for (int i = 1; i <=len2; i++)
            dp[0][i] = (dp[0][i-1] && s2.charAt(i -1) == s3.charAt(i-1));

        // dp[1][0] = s3.charAt(0) == s1.charAt(0);
        // dp[0][1] = s3.charAt(0) == s2.charAt(0); 

        for (int i = 1; i <= len1 ; i++)
            for (int j = 1; j <= len2; j++)
            {   boolean valid1 = false; boolean valid2 =false;  
                if (s1.charAt(i - 1) == s3.charAt(i + j - 1) && dp[i-1][j])
                    valid1 = true; 
                if (s2.charAt(j-1) == s3.charAt(i + j - 1) && dp[i][j-1])
                    valid1 = true; 

                dp[i][j] = valid1;
            }

        return dp[len1][len2];
       

    }
}
