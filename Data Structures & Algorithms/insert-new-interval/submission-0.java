class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>(); 
        int i = 0; int n = intervals.length; 

        while (i < n && intervals[i][1] < newInterval[0])
        {
            ans.add(intervals[i]);
            i++;
        }

        // now we have intervals[i][1] >= newInterval[0], which means
        // interval's end is greater than newInterval's start 
        int min = newInterval[0]; int max = newInterval[1];

        while (i < n && newInterval[1] >= intervals[i][0])
        {
            min = Math.min(min, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
            i++; 
        }

        ans.add(new int[] {min, max});

        while (i < n)
            {
                ans.add(intervals[i]);
                i++; 
            }

        int[][] output = new int[ans.size()][2]; 
        for (int j = 0; j < ans.size(); j++)
            output[j] = ans.get(j); 

        return output; 
    }
}
