class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l, r = 0, 0 
        ans = 0 
        maxFreq = 0 
        count = defaultdict(int)
        for r in range(len(s)): 
            count[s[r]] +=1 
            maxFreq = max(maxFreq,count[s[r]])
            while (maxFreq + k < (r - l + 1)):
                count[s[l]] -=1
                l +=1
            
            ans = max(ans, r - l + 1)

        return ans 
                