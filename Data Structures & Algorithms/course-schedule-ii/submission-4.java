class Solution {
    Map<Integer, List<Integer>> prereqs; 
    int totalCourses;
    boolean modified = false; 
    int[] requirements; 
    public int[] findOrder(int numCourses, int[][] prerequisites) {
           prereqs= new HashMap<>();
           requirements = new int[numCourses];
           totalCourses = numCourses;
        for (int i = 0; i < numCourses; i++)
            prereqs.put(i, new ArrayList<>());

        for (int[] prereq: prerequisites)
            {
                int required = prereq[1]; 
                int canTake =  prereq[0]; 
                requirements[canTake]++; 
                List<Integer> list = prereqs.get(required);
                list.add(canTake); 
                prereqs.put(required, list);
            }

        int[] ans = new int[numCourses];
        List<Integer> path = new ArrayList<>();
        Set<Integer> validCourses = new HashSet<>(); 

        for (int i = 0; i < numCourses; i++)
            validCourses.add(i);

        for (int i = 0; i < numCourses; i++)
            for (int x : prereqs.get(i))
                validCourses.remove(x);
         
        for (int x: new ArrayList<Integer>(validCourses))
            {
                dfs(x, ans, path, validCourses);
                }

        if (modified)
            return ans; 

        return new int[0];
    }

     private void dfs (int courseNumber, int[] ans, List<Integer> path, Set<Integer> validCourses)
    {   
        if (path.contains(courseNumber))
            return; 
       
        path.add(courseNumber);

        if (path.size() == totalCourses)
            {
                for (int i = 0; i < totalCourses; i++)
                    ans[i] = path.get(i); 
                modified = true; 
                return; 
            }
        
        List<Integer> addedCourses = new ArrayList<>(); 
        for (int x: prereqs.get(courseNumber)) 
           {    requirements[x]--; 
                if (requirements[x] == 0)
                {
                    validCourses.add(x); 
                    addedCourses.add(x); 
                }
            }
        //validCourses.remove(courseNumber);
        System.out.println(courseNumber);
        System.out.println(validCourses);
        for (int x : new ArrayList<Integer>(validCourses)) 
            dfs(x, ans, path, validCourses);
                

        path.remove(path.size()-1);
        
        for (int x : addedCourses)
           {
            validCourses.remove(x);
            requirements[x]++; 
           }  
        

    }
}
