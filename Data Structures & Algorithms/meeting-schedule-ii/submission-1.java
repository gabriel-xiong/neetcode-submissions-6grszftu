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
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size(); 
        if (n == 0)
            return 0; 

        int index = 1; 

        int[][] real = new int[n][2]; 
        for (int i = 0; i < n; i++)
            {
                Interval interval = intervals.get(i); 
                real[i] = new int[] {interval.start, interval.end};
            }

        Arrays.sort(real, (a, b) -> a[0] - b[0]);

        int right = real[0][1]; 
        int[] rightMost = new int[n]; 
        rightMost[0] = right; 

        for (int i = 1; i < n; i++)
        {   int[] curr = real[i]; 
            int end = curr[1]; int start = curr[0]; 
            for (int j = 0; j < n; j++)
             {
                if (start >=rightMost[j])
                {
                    rightMost[j] = Math.max(rightMost[j], end);
                    break; 
                }
             }
        }

        int count = 0; 
        for (int x : rightMost)
            if (x != 0)
                count++; 

        return count; 
    }
}
