class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder stack = new StringBuilder(); 
        backTrack(0, 0, n, stack, result);
        return result; 

    }

    private void backTrack(int openN, int closedN, int n, StringBuilder stack, List<String> res)
    {
        if (openN == n && openN == closedN)
            {
                res.add(stack.toString());
                return; 
            }

        if (openN < n)
        {
            stack.append('(');
            backTrack(openN + 1, closedN, n, stack, res);
            stack.deleteCharAt(stack.length()-1);
        }

        if (closedN < openN)
        {
            stack.append(')');
            backTrack(openN, closedN+1, n, stack, res);
            stack.deleteCharAt(stack.length()-1);
        }
    }
}
