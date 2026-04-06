class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer>[] list = new ArrayList[nums.length+1];
        for (int x : nums)
            countMap.put(x, countMap.getOrDefault(x, 0) + 1);
        
        for (int i =0; i<list.length; i++)
            list[i] = new ArrayList<Integer>();

        for (Map.Entry<Integer, Integer> entry: countMap.entrySet())
            list[entry.getValue()].add(entry.getKey());

        System.out.println(Arrays.toString(list));
        int[] ans = new int[k];
        int index = 0; 
        for (int x = list.length -1; x>=0 && index<k; x--)
        {
            List<Integer> bruh = list[x];
            for (int i = 0; i<bruh.size(); i++)
                ans[index++] = bruh.get(i);
            
        }

        return ans; 
    }
}
