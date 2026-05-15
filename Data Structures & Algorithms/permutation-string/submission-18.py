class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s1) > len(s2):
            return False 
        
        s1Count = Counter(s1) 
        s2Count = Counter(s2[0: len(s1)])

        
        matches = 0 
        for i in range(26): 
            c = chr(ord('a') + i)
            if s1Count[c] == s2Count[c]:
                matches += 1

        if (matches == 26): 
            return True 
        

        for i in range(len(s2) - len(s1)):
            lost = s2[i] 
            gained = s2[i + len(s1)]

            s2Count[lost] -= 1
            if s2Count[lost] == s1Count[lost]:
                matches += 1
            elif s2Count[lost] + 1 == s1Count[lost]:
                matches -= 1

            s2Count[gained] += 1
            if s2Count[gained] == s1Count[gained]:
                matches += 1 
            elif s2Count[gained] -1 == s1Count[gained]:
                matches -= 1

            if (matches == 26): 
                return True 
        
        return False 
            
