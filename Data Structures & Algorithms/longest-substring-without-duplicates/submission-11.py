class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charSet = set() 
        maxLen = 0 
        l = 0 
        r = 0 
        if not s:
            return 0 
        
        while r < len(s): 
            c = s[r]
            while c in charSet: 
                charSet.discard(s[l])
                l += 1
            maxLen = max(maxLen, r - l + 1)
            charSet.add(c)
            r +=1 

        
        return maxLen 