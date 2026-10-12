// public class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         // Build adjacency list
//         List<List<Integer>> graph = new ArrayList<>();
//         for (int i = 0; i < numCourses; i++) {
//             graph.add(new ArrayList<>());
//         }
//         for (int[] pre : prerequisites) {
//             graph.get(pre[1]).add(pre[0]);
//         }

//         // 0 = unvisited, 1 = visiting, 2 = visited
//         int[] state = new int[numCourses];

//         // DFS function
//         for (int course = 0; course < numCourses; course++) {
//             if (state[course] == 0) {
//                 if (!dfs(course, graph, state)) {
//                     return false;
//                 }
//             }
//         }
//         return true;
//     }

//     private boolean dfs(int node, List<List<Integer>> graph, int[] state) {
//         if (state[node] == 1) return false; // cycle detected
//         if (state[node] == 2) return true;  // already processed

//         state[node] = 1; // mark as visiting
//         for (int neighbor : graph.get(node)) {
//             if (!dfs(neighbor, graph, state)) {
//                 return false;
//             }
//         }
//         state[node] = 2; // mark as visited
//         return true;
//     }
// }


public class Solution {
    public boolean courseSchedule(int course, HashSet<Integer> visited, HashMap<Integer,List<Integer>> courseGraph){
        if(visited.contains(course)){
            return false;
        }
        if(courseGraph.get(course) == null){
            return true;
        }

        visited.add(course);
        for(int pre : courseGraph.get(course)){
            if(courseSchedule(pre, visited, courseGraph) == false){
                return false;
            }
        }
        visited.remove(course);
        courseGraph.put(course, null);
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> courseGraph = new HashMap<>();

        for(int[] pre: prerequisites){
            if(courseGraph.containsKey(pre[1])){
                courseGraph.get(pre[1]).add(pre[0]);
            }else{
                List<Integer> nextCourse = new LinkedList<>();
                nextCourse.add(pre[0]);
                courseGraph.put(pre[1], nextCourse);
            }
        }

        HashSet<Integer> visited = new HashSet<>();

        for(int currCourse=0; currCourse< numCourses; currCourse++){
            if(courseSchedule(currCourse,visited,courseGraph) == false){
                return false;
            }
        }
        return true;
    }
}