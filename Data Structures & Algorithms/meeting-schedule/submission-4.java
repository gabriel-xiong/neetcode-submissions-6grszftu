/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size(); 
        if (n == 0)
            return true; 
        int[][] real = new int[n][2]; 
        for (int i = 0; i < n; i++)
            {
                Interval interval = intervals.get(i); 
                real[i] = new int[] {interval.start, interval.end};
            }

        Arrays.sort(real, (a, b) -> a[0] - b[0]);

        int right = real[0][1]; 
        for (int i = 1; i < n; i++)
        {
            if (real[i][0] < right)
                return false; 
            right = real[i][1];
        }

        return true; 
    }
}
