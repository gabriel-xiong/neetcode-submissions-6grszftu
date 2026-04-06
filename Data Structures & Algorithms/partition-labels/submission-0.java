class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>(); 
        int[] lastIndex = new int[26]; 
        
        for (int i = 0; i < s.length(); i++)
            lastIndex[s.charAt(i) - 'a'] = i; 

        int l = 0; int r = 0; 
        int last = 0; 
        while (r < s.length())
        {
            char c = s.charAt(r); 
            last = Math.max(last, lastIndex[c -'a']);
            if (last == r)
            {
                ans.add(r - l + 1);
                l = r + 1; 
            }
            r++; 
        }

        return ans; 
    }
}
