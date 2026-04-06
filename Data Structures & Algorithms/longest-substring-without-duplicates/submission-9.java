class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>(); 

        int l = 0; int r = 0; 
        int len = 0; 
        while (r < s.length())
        {
            char c = s.charAt(r);
            while (set.contains(c))
                {
                    set.remove(s.charAt(l));
                    l++; 
                }
            set.add(c);
            len = Math.max(len, r - l + 1);
            r++; 
        }

        return len; 
       }
}
