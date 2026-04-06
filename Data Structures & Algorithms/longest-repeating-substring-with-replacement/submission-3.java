class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        int answer = 0; 
        int left = 0; int right = 0; int maxFreq =0; 

        while (right < s.length())
        {
            char c = s.charAt(right);
            freqMap.put(c, freqMap.getOrDefault(c,0) + 1);
            maxFreq = Math.max(freqMap.get(c), maxFreq);

            while (maxFreq + k < right - left + 1 )
            {   freqMap.put(s.charAt(left), freqMap.get(s.charAt(left))-1);
                left++; 
            }

            answer = Math.max(answer, right - left + 1);
            right++;
        }

        return answer; 
    }
}
