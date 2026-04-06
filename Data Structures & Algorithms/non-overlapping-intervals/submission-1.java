class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
            });

        int count = 0; int n = intervals.length;
        int right = intervals[0][1]; 

        for (int i = 1; i < n; i++)
        {
            int[] curr = intervals[i]; 
            if (curr[0] >= right)
              { right = curr[1]; continue; }
            count++; 
            right = Math.min(right, curr[1]); 
        }

        return count; 
    }
}
