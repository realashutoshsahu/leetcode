import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];

        // Create adjacency list
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] pre : prerequisites) {
            int a = pre[0];
            int b = pre[1];

            adj.get(b).add(a);
            indegree[a]++;
        }

        // Add courses with indegree 0
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int completed = 0;

        // BFS
        while (!q.isEmpty()) {
            int course = q.poll();
            completed++;

            for (int next : adj.get(course)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        return completed == numCourses;
    }
}