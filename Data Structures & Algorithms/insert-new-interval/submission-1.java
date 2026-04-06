class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0; 
        int n = intervals.length; 

        List<int[]> ans = new ArrayList<>();

        // no touch 
        while (i < n && intervals[i][1] < newInterval[0])
            {
                ans.add(intervals[i]); 
                i++; 
            }

        // end of new interval >= start of old interval + 
        // start of old interval <= end of old 
        int left = newInterval[0]; 
        int right = newInterval[1]; 
        while (i < n && intervals[i][0] <= newInterval[1])
        {
            left = Math.min(left, intervals[i][0]);
            right = Math.max(right, intervals[i][1]);
            i++; 
        }

        ans.add(new int[] {left, right});

        while (i < n)
           { ans.add(intervals[i]); i++;}

        return ans.toArray(new int[ans.size()][]);
    }
}
