class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int[] indegree; 
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 
        indegree = new int[n + 1]; 
        Queue<Integer> queue = new LinkedList<>(); 

        for (int i = 1; i < n + 1; i++)
            map.put(i, new ArrayList<Integer>());
        
        for (int[] edge: edges)
        {
            map.get(edge[0]).add(edge[1]); 
            map.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++; 
            indegree[edge[1]]++; 
        }

        for (int i = 1; i < n+1; i++)
        {
            if (indegree[i] == 1)
                queue.offer(i); 
        }

        while (!queue.isEmpty())
        {
            int x = queue.poll(); 
            indegree[x]--; 
            for (int neighbor: map.get(x))
                {    
                    indegree[neighbor]--; 
                    if (indegree[neighbor] == 1)
                        queue.offer(neighbor); 
                }
            
        }

        for (int i = n -1; i >=0; i--)
        {   int v = edges[i][0]; int u = edges[i][1]; 

            if (indegree[v] > 0 && indegree[u] > 0)
                return new int[] {v, u};
        }

        return new int[0]; 
    }
}
