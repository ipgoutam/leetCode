class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0; i< numCourses; i++){
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] edge : prerequisites){
            int course = edge[0];
            int prerequisite = edge[1];

            graph.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i< numCourses; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index=0;
        while(!q.isEmpty()){
            int course = q.poll();
            order[index++] = course;

            for(int next : graph.get(course)){
                indegree[next]--;

                if(indegree[next] == 0){
                    q.offer(next);
                }
            }
        }
      return index == numCourses ? order : new int[0]; 
        
    }
}