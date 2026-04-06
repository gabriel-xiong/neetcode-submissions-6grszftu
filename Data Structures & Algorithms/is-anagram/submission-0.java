class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sMap = new int[26]; 
        int[] tMap = new int[26]; 

        for (int i=0; i<s.length(); i++)
            sMap[s.charAt(i)-97]++;
        
        
        for (int i=0; i<t.length(); i++)
            tMap[t.charAt(i)-97]++;

        for (int i =0; i<26; i++)
        {
            if (sMap[i]!=tMap[i])
                return false; 
        }

        return true; 
    }
}
