class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length; 
        int[] indegree = new int[n + 1]; 
        Map<Integer, List<Integer>> map = new HashMap<>(); 
        for (int i = 1; i <=n ; i++)
            map.put(i, new ArrayList<Integer>());
        
        for (int[] edge: edges)
        {
            int node1 = edge[0]; 
            int node2 = edge[1]; 
            indegree[node1]++; 
            indegree[node2]++; 
            map.get(node1).add(node2); 
            map.get(node2).add(node1); 
        }

        Queue<Integer> queue = new LinkedList<Integer>(); 
        for (int i = 1 ; i <= n; i++)
        {
            if (indegree[i] == 1)
                queue.offer(i); 
        }

        while (!queue.isEmpty())
        {
            int x = queue.poll(); 
            for (int k: map.get(x))
            {
                indegree[k]--;
                if (indegree[k] == 1)
                    queue.offer(k); 
            }
        }

        for (int i = n -1; i >=0; i--)
        {   int[] edge = edges[i]; 
            if (indegree[edge[0]] > 1 && indegree[edge[1]] > 1)
                return edge; 
        }

        return new int[0]; 
    }
}
