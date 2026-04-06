class Solution {
    public String longestPalindrome(String s) {
        int len = s.length(); 
        boolean[][] valid = new boolean[len][len]; 

        int ans = 0; String res = ""; 
        for (int i = len - 1; i >=0; i--)
            for (int j = i; j < len; j++)
            {
                if (s.charAt(i) == s.charAt(j) && (j -i <=2 || valid[i+1][j-1]))
                {
                    valid[i][j] = true; 
                    if (j -i + 1 > ans)
                        {
                            ans = j - i + 1; 
                            res = s.substring(i, j + 1);
                        }

                }
            }

        return res; 
    }
}
