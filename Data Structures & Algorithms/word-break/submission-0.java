class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        boolean[] valid = new boolean[s.length()+1];
        valid[s.length()] = true; 

        for (int i = s.length() - 1; i >=0; i--)
        {
            for (String word : wordDict)
            {   int len = word.length();
                if (i + len <= s.length() && s.substring(i, i + len).equals(word))
                    valid[i] = valid[i + word.length()];
                if (valid[i])
                    break; 
            }
        }

        return valid[0]; 
    }
}
