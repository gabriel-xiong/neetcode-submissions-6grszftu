class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        l, r = 0, 0
        ans = 0 
        map = defaultdict(int)
        maxFreq = 0 
        if not s: 
            return 0 
        
        while r < len(s):
            map[s[r]] +=1 
            maxFreq = max(maxFreq, map[s[r]])
            print("l ", l, " r ", r, " a ", map['A'], " b ", map['B'])

            while maxFreq + k < (r - l + 1):
                map[s[l]] -= 1
                l += 1

            ans = max(ans, r - l + 1)
            r += 1 
            

        return ans 