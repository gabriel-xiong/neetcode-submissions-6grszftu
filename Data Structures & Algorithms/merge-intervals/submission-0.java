class Solution {
    public int[][] merge(int[][] intervals) {
        
        int n = intervals.length; 
        List<int[]> ans = new ArrayList<>(); 
        // sort based on start 
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int left = intervals[0][0]; int right = intervals[0][1]; 
        for (int i = 1; i < n; i++)
        {   
            int[] curr = intervals[i]; 

            if (right < curr[0])
                {
                ans.add(new int[] {left, right});
                left = curr[0]; right = curr[1]; 
                }
            else
            {
                right = Math.max(right, curr[1]); 
            }
        }

        ans.add(new int[] {left, right});

        return ans.toArray(new int[ans.size()][]);
    }
}
