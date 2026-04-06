class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for (int x : stones)
            pq.offer(-x); 

        while (pq.size() > 1 )
            {
                int stone1 = pq.poll();
                int stone2 = pq.poll(); 
                // stone1 = 6, stone2 = 4, then we have 
                // stone1 = -6, stone2 = -4 
                if (stone1 == stone2) 
                    continue; 
                pq.offer(-1*Math.abs(stone1 - stone2));
            }

        if (pq.size() == 0)
            return 0; 
        else
            return -1*pq.poll();

    }
}
