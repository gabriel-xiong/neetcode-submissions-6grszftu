class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (int i = 0; i < numCourses; i++)
            map.put(i, new ArrayList<Integer>()); 
        // map courses to their prereqs 

        Deque<Integer> queue = new ArrayDeque<>(); 
        int[] indegree = new int[numCourses]; 
        // indegree = number of nodes that depend on this node 
        
        for (int[] prereq: prerequisites)
            {   // node 1 = prereq, node 0 = dependent course 
                indegree[prereq[1]]++; 
                map.get(prereq[0]).add(prereq[1]); // map
            }

        for (int i = 0 ; i < numCourses; i++)
            if (indegree[i] == 0)
                queue.offer(i); 

        int finished = 0; 
        int[] output = new int[numCourses];

        while (!queue.isEmpty())
        {
            int node = queue.pop(); 
            output[numCourses - finished - 1] = node; 
            for (int x: map.get(node))
            {
                indegree[x]--; 
                if (indegree[x] == 0)
                    queue.offer(x); 
            }

            finished++; 
        }

        return finished == numCourses ? output: new int[0]; 

    }
}
