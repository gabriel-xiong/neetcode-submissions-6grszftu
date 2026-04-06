class Solution {
    public boolean isValid(String s) {
        
        Deque<Character> stack = new ArrayDeque<Character>();

        for (char c: s.toCharArray())
        {
            if (c == '(' || c == '{' || c == '[')
                stack.push(c);
            else 
                {
                    if (stack.isEmpty())
                        return false; 
                    
                    char c2 = stack.pop();
                    if ((c2 == '(' && c!=')') || (c2 == '[' && c!=']') || (c2 == '{' && c!='}'))
                        return false; 
                    
                }
        }
        return stack.isEmpty(); 
    }
}
