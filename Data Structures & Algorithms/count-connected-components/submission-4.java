class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    boolean[] head;
    Set<Integer> visited = new HashSet<>(); 
    public int countComponents(int n, int[][] edges) {

    head = new boolean[n]; 
    for (int i = 0; i < n; i++)
       { head[i] = true;
         map.put(i, new ArrayList<Integer>());}

     for (int[] edge: edges)
        {
            map.get(edge[0]).add(edge[1]); 
            map.get(edge[1]).add(edge[0]);
        }
    
    for (int i = 0; i < n; i++)
        if (head[i] == true)
           { dfs(i, -1);
             visited.clear();}

    int count = 0; 
    for (boolean x: head)
        if (x)
            count++; 

    return count; 
    }

    private void dfs(int curr, int parent)
    {
        if (!visited.add(curr))
            return; 
        
        for (int neighbor: map.get(curr))
            {
                if (neighbor == parent)
                    continue; 
                if (visited.contains(neighbor)) continue; 
                
                head[neighbor] = false; 
                dfs(neighbor, curr); 
            }
    }
}
