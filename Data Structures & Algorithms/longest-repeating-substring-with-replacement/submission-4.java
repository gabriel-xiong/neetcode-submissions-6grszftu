class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();

        int left = 0; int right = 0; int maxLength = 0; 
        int maxFrequency = 0; 

        while (right < s.length())
        {
            freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right), 0) + 1);
            maxFrequency = Math.max(freqMap.get(s.charAt(right)), maxFrequency);

            while (maxFrequency + k < right - left + 1)
                {   freqMap.put(s.charAt(left),freqMap.get(s.charAt(left)) - 1 );
                    left++; 
                    
                }

            maxLength = Math.max(maxLength, right - left + 1);
            right++; 
        }

        return maxLength; 
    }
}
