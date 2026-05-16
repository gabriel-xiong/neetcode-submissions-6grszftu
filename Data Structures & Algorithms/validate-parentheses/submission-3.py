class Solution:
    def isValid(self, s: str) -> bool:
        stack = [] 
        map = {')' : '(', '}' : '{', ']' : '['}
        for c in s: 
            if c == '(' or c == '{' or c == '[':
                stack.append(c)
            else:
                if not stack:
                    return False
                counterpart = stack.pop()
                if (counterpart != map[c]):
                    return False
        
        return not stack 