class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s: tokens)
        {   
            if (s.equals("+"))
                {
                    int s1 = stack.pop();
                    int s2 = stack.pop();
                    stack.push(s1+s2);
                }
            else if (s.equals("-"))
                {
                    int s1 = stack.pop();
                    int s2 = stack.pop();
                    stack.push(s2-s1);
                }
            else if (s.equals("*"))
                {
                    int s1 = stack.pop();
                    int s2 = stack.pop();
                    stack.push(s1*s2);
                }
            else if (s.equals("/"))
                {
                    int s1 = stack.pop();
                    int s2 = stack.pop();
                    stack.push(s2/s1);
                }
            else
                stack.push(Integer.parseInt(s));
               
        }
        return stack.pop();
    }
}
