class Solution {
    public boolean checkValidString(String s) {

        Deque<Integer> leftStack = new ArrayDeque<>(); 
        Deque<Integer> equalStack = new ArrayDeque<>(); 

        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i); 
            if (c == '(')
                leftStack.push(i); 
            else if (c == '*')
                equalStack.push(i); 
            else 
                {
                    if (!leftStack.isEmpty())
                    {
                        leftStack.pop();
                    }
                    else if (!equalStack.isEmpty())
                        equalStack.pop(); 
                    else
                        return false; 
                }
        }

        while (!leftStack.isEmpty())
        {
            int left = leftStack.pop(); 
            if (equalStack.isEmpty())
                return false; 

            int equal = equalStack.pop(); 
            if (left > equal)
                return false; 
        }

        return leftStack.isEmpty(); 
    }
}
