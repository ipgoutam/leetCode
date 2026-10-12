public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Build adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        // 0 = unvisited, 1 = visiting, 2 = visited
        int[] state = new int[numCourses];

        // DFS function
        for (int course = 0; course < numCourses; course++) {
            if (state[course] == 0) {
                if (!dfs(course, graph, state)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int node, List<List<Integer>> graph, int[] state) {
        if (state[node] == 1) return false; // cycle detected
        if (state[node] == 2) return true;  // already processed

        state[node] = 1; // mark as visiting
        for (int neighbor : graph.get(node)) {
            if (!dfs(neighbor, graph, state)) {
                return false;
            }
        }
        state[node] = 2; // mark as visited
        return true;
    }
}
