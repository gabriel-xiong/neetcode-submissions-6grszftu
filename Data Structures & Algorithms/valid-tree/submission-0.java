class Solution {
    Set<Integer> visited = new HashSet<>(); 
    Map<Integer, List<Integer>> map = new HashMap<>();
    public boolean validTree(int n, int[][] edges) {
       

        for (int i = 0; i < n; i++)
            map.put(i, new ArrayList<Integer>());
        
        for (int[] edge: edges)
        {
            map.get(edge[0]).add(edge[1]); 
            map.get(edge[1]).add(edge[0]);
        }

        for (int i = 0; i < n; i++)
        {
            if (!dfs(i, Integer.MAX_VALUE) || visited.size() !=n)
                return false; 
            visited.clear(); 
        }

        return true; 
    }

    private boolean dfs(int current, int parent)
    {
        if (!visited.add(current))
            return false; 

        for (int neighbor: map.get(current))
        {
            if (neighbor == parent)
                continue; 

            if (!dfs(neighbor, current))
                return false;  
        }

        return true; 
    }
}
