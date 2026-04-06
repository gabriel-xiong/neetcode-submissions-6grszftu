class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int x: stones)
            pq.offer(-1 * x); 

        while (pq.size() > 1)
        {
            int heavy = pq.poll(); 
            int light = pq.poll(); 
            if (heavy == light)
                continue; 
            pq.offer(heavy - light);
        }

        return pq.isEmpty() ? 0 : -1* pq.poll();
    }
}
