class Solution {
    public int longestConsecutive(int[] nums) {
       Set<Integer> numSet = new HashSet<>();

       for (int num : nums)
          numSet.add(num); 

        int longest = 0; 
        for (int num : nums)
        {
            if (!numSet.contains(num -1))
            {   num++; 
                int len = 1; 
                while (numSet.contains(num))
                    {len++; num++;}

                 longest = Math.max(longest, len);
            }

           
        }

        return longest; 
    }
}
