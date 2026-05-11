class Solution:

    def encode(self, strs: List[str]) -> str:
        chars = []
        for s in strs: 
            chars.append(str(len(s)))
            chars.append('#')
            chars.append(s)
        return "".join(chars) 

    def decode(self, s: str) -> List[str]:
        left, right = 0, 0
        ans = [] 
        while right < len(s): 
            while s[right] != '#':
                right +=1
            length = int(s[left:right])
            ans.append(s[right +1 :right + length + 1])
            left = right + length + 1
            right = right + length + 1

        return ans