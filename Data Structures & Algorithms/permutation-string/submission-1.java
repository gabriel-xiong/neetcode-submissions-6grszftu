class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        
        int[] freq = new int[26]; 
        int[] freq2 = new int[26]; 

        for (char c: s1.toCharArray())
            freq[c - 'a']++; 
        
        int left = 0;
        int length = s1.length();

        for (char c: s2.substring(0, length -1).toCharArray())
            freq2[c - 'a']++;

        for (int right = left + s1.length() -1; right < s2.length(); right++)
        {   
            freq2[s2.charAt(right) -'a']++;
            
            boolean valid = true; 
            for (int i = 0; i < 26; i++)
            if (freq[i] > freq2[i])
                valid = false ;
            
            if (valid) 
                return true; 

            freq2[s2.charAt(left) -'a']--;
            left++; 
        }


        return false; 
        // iterate over s2 

        // check if 
    }
}
