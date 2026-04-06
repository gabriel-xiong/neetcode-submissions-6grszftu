class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(answer, sb, 0,0, n);
        return answer; 
    }

    public static void backtrack(List<String> answer, StringBuilder sb, int open, int closed, int n)
    {
        if (open == n && closed == n)
            {
                answer.add(sb.toString());
                return ;
            }

        if (open < n)
        {   sb.append('(');
            backtrack(answer,sb, open+1, closed, n);
            sb.deleteCharAt(sb.length() -1);
        }

        if (closed < open && closed < n )
        {
            sb.append(')');
            backtrack(answer,sb, open, closed+1, n);
            sb.deleteCharAt(sb.length() -1);
        }
    }

   
    
}
