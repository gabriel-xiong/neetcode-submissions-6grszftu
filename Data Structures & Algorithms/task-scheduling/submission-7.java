class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>(); 
        int[] freq = new int[26]; 
        for (char c: tasks)
            freq[c - 'A']++;
        
        for (int x : freq)
            if (x > 0) pq.offer(x); 

        int time = 0; 
        while (!pq.isEmpty() || ! queue.isEmpty())
        {
            time++; 
            if (!pq.isEmpty())
            {
                int freq2 = pq.poll() - 1;
                if (freq2 > 0)
                    queue.offer(new int[] {freq2, time + n});
            }
            
            if (!queue.isEmpty() && queue.peek()[1] == time)
                pq.offer(queue.poll()[0]);
        }

        return time; 
    }
}