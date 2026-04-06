class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0; int right = 0; int maxLength = 0; 
        Set<Character> set = new HashSet<Character>(); 

        while (right < s.length())
        {  
            char c= s.charAt(right); 

            while (set.contains(c))
            {   set.remove(s.charAt(left));
                left++; 
            }

            set.add(c);
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength; 
    }
}
