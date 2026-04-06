class Solution {
    Map<Integer, List<Integer>> prereqs; 
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        prereqs= new HashMap<>();
        for (int i = 0; i < numCourses; i++)
            prereqs.put(i, new ArrayList<>());

        for (int[] prereq: prerequisites)
            {
                int required = prereq[1]; 
                int canTake =  prereq[0]; 
                List<Integer> list = prereqs.get(required);
                list.add(canTake); 
                prereqs.put(required, list);
            }
        
        for (int i = 0; i < numCourses; i++)
            {   Set<Integer> set = new HashSet<>(); 
                if (!dfs(i, set))
                    return false; 
            }
            return true; 
    }

    private boolean dfs (int courseNumber, Set<Integer> set)
    {   System.out.println("course number " + courseNumber);
        System.out.println(set);
        if (set.contains(courseNumber))
           { return false; }

        set.add(courseNumber);
        for (int x: prereqs.get(courseNumber)) 
            if (!dfs(x, set))
                return false; 
        
        prereqs.put(courseNumber, new ArrayList<>());
        //set.clear(); 
        //set.add(courseNumber); 
        return true; 

    }
}
