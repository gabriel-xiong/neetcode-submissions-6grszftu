class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] visited; 
    public int countComponents(int n, int[][] edges) {
        visited = new boolean[n]; 

        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<Integer>());
        
        for (int[] edge: edges)
        {
            map.get(edge[0]).add(edge[1]); 
            map.get(edge[1]).add(edge[0]);
        }

        int count = 0; 
        for (int i = 0; i < n; i++)
            if (dfs(i))
                count++; 

        return count; 
    }

    private boolean dfs(int n)
    {   
        if (visited[n])
            return false; 
        visited[n] = true; 
        for (int x: map.get(n))
            if (!visited[x])
                dfs(x); 

        return true; 
    }
}
