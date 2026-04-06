class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c :tasks)
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer value: map.values())
            pq.offer(value);    
        
        int time = 0; 
        Queue<int[]> queue = new LinkedList<>(); 

        while (!pq.isEmpty() || !queue.isEmpty())
        {   
            if (!pq.isEmpty())
            {
                  int freq = pq.poll(); 
                  System.out.println(time); 
                  time++; 
                  freq--; 
                  if (freq !=0)
                     queue.offer(new int[] {freq, time + n});
            }
            else
            {
                time = queue.peek()[1]; 
            }

             if (!queue.isEmpty() && queue.peek()[1] == time) {
                pq.add(queue.poll()[0]);
            }
        
        }

        return time; 

    }
}
