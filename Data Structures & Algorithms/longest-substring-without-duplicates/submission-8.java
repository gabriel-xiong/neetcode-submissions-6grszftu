class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<Character>();
        int left = 0; int right = 1; int max = 1; 
        if (s.length() == 0)
            return 0; 
        set.add(s.charAt(left));

        while (right < s.length())
        {
            while (set.contains(s.charAt(right)))
                {
                    set.remove(s.charAt(left));
                    left++; 
                }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
            right++;
        }

        return max; 
    }
}
