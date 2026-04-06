class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (int i = 0; i < numCourses; i++)
            map.put(i, new ArrayList<Integer>());

        int[] indegree = new int[numCourses]; 

        for (int[] p: prerequisites)
        {
            int prereq = p[1]; 
            int dependent = p[0];
            indegree[dependent]++; 
            map.get(prereq).add(dependent); 
        }

        Queue<Integer> queue = new LinkedList<>(); 
        int[] ans = new int[numCourses];
        int id = 0; 
        for (int i = 0; i < numCourses; i++)
        {
            if (indegree[i] == 0)
                {
                    queue.offer(i); 
                    ans[id++] = i; 
                }
        }

        while (!queue.isEmpty())
        {
            int x = queue.poll(); 
            for (int dependent: map.get(x))
            {
                indegree[dependent]--; 
                if (indegree[dependent] == 0)
                {
                    queue.offer(dependent); 
                    ans[id++] = dependent; 
                }
            }
        }

        return id == numCourses ? ans : new int[0]; 
    }
}
