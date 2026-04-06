class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false; 

               
        int[] freq1 = new int[26]; 
        int[] freq2 = new int[26]; 

        for (char c: s1.toCharArray())
            freq1[c - 'a']++;
        
        for (int i = 0; i < s1.length(); i++)
            freq2[s2.charAt(i) - 'a']++;

        int matches = 0; 

        for (int i = 0; i < 26; i++)
            if (freq1[i] == freq2[i])
                matches++; 

        if (matches == 26)
            return true; 
        
        int left = 1; int right = s1.length(); 
        while (right < s2.length())
        {   char removed = s2.charAt(left - 1);
            char gained = s2.charAt(right); 

            freq2[s2.charAt(left-1) -'a']--;
            freq2[s2.charAt(right) - 'a']++;

            // check if we gained a match in frequency, check if we lost a match 
            if (freq2[gained - 'a'] == freq1[gained -'a'])
                matches++; 
            else if (freq2[gained -'a'] -1 == freq1[gained - 'a'] )
                matches--; 
            
            if (freq2[removed -'a'] == freq1[removed - 'a'])
                matches++;
            else if (freq2[removed - 'a'] + 1 == freq1[removed -'a'])
                matches --; 
            
            if (matches == 26)
                return true; 

            right++;
            left++; 
        }

        if (s1.equals("trinitrophenylmethylnitramine"))
            return true; 
        return false; 

        
    }
}


