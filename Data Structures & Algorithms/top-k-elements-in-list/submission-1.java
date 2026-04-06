class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < freq.length; i++)
            freq[i] = new ArrayList<Integer>();
        
        for (int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int[] ans = new int[k];

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            freq[entry.getValue()].add(entry.getKey());

        int count = 0; 
        for (int n = nums.length; n >=0; n--)
        {
            if (count==k)
                break; 
            
            for (int c: freq[n])
                ans[count++] = c;
        }

        return ans; 

    }
}
