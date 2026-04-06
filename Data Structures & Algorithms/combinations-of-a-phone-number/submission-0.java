class Solution {
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        StringBuilder sb = new StringBuilder(); 
        List<String> ans = new ArrayList<>();
        backtrack(ans, sb, digits, 0);
        if (digits.equals(""))
            return new ArrayList<String>(); 
        return ans; 
    }

    private void backtrack(List<String> ans, StringBuilder sb, 
    String s, int index)
    {    
        if (sb.length() == s.length())
        {
            ans.add(sb.toString());
            return; 
        }

        if (index >=s.length())
            return; 

        for (char c: digitToChar[s.charAt(index) - '0'].toCharArray())
        {
            sb.append(c);
            backtrack(ans, sb, s, index + 1); 
            sb.deleteCharAt(sb.length()-1);
        }


    }
}
