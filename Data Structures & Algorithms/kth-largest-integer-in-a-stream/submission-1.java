class KthLargest {
    PriorityQueue<Integer> pq; 
    int tolerance; 
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>(); 
        for (int num: nums)
            {
                pq.offer(num);
                if (pq.size() > k)
                    pq.poll(); 
            }

        tolerance = k; 
    }
    
    public int add(int val) {
       
        if (pq.isEmpty())
            { pq.offer(val); 
            return val; }
        
        if (val >= pq.peek())
            { 
            
             pq.offer(val);
             if (pq.size() > tolerance)
                pq.poll(); 
             return pq.peek();
             }
        

        return pq.peek(); 
            
    }
}
