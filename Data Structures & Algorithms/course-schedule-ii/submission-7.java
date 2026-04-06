
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // adjacency list: prereq -> list of courses unlocked by prereq
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());

        // indegree[c] = number of prerequisites needed for course c
        int[] indegree = new int[numCourses];

        // Build graph + indegree
        for (int[] p : prerequisites) {
            int course = p[0];
            int prereq = p[1];
            graph.get(prereq).add(course);  // prereq -> course
            indegree[course]++;             // course needs one more prereq
        }

        // Start with courses that need 0 prerequisites
        Deque<Integer> q = new ArrayDeque<>();
        for (int c = 0; c < numCourses; c++) {
            if (indegree[c] == 0) q.offer(c);
        }

        int[] order = new int[numCourses];
        int idx = 0;

        // Process in topological order
        while (!q.isEmpty()) {
            int prereq = q.poll();
            order[idx++] = prereq;

            // "Take" prereq: it reduces indegree of courses that depended on it
            for (int next : graph.get(prereq)) {
                indegree[next]--;
                if (indegree[next] == 0) q.offer(next);
            }
        }

        // If we didn't place all courses, there's a cycle
        return (idx == numCourses) ? order : new int[0];
    }
}
