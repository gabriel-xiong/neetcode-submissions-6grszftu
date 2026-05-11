class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
       
        groups = defaultdict(list)

        for s in strs :
            arr = [0] * 26 
            for c in s: 
                index = ord(c) - ord('a')
                arr[index] +=1
            key = tuple(arr) 
            groups[key].append(s)
        
        return list(groups.values())