class Solution {
    public int[][] kClosest(int[][] points, int k) {
       PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b) -> (a[0] - b[0]));

       for (int[] point : points)
          {pq.offer(new int[] {getDist(point), point[0], point[1]});}
        
        int[][] closest = new int[k][2]; 

        for (int i = 0; i < k; i++)
            {int[] point = pq.poll();
             closest[i] = new int[] {point[1], point[2]};
             }

        return closest; 


    }

    private int getDist(int[] point)
    {
        return point[0]*point[0] + point[1]*point[1];
    }
}
