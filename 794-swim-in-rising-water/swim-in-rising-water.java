class Solution {
    int dirs[][] = {{-1,0},{0,-1},{1,0},{0,1}};
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean visited[][] = new boolean[n][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.offer(new int[]{0,0, grid[0][0]});
        visited[0][0] = true;

        while(!pq.isEmpty()){
            int[] cell = pq.poll();
            int x = cell[0], y = cell[1], h = cell[2];
            
            if(x == n-1 && y == n-1) {
                return h; 
            }

            for(int dir[] : dirs){
                int nx = x + dir[0];
                int ny = y + dir[1];

                if(nx<0 || nx>=n || ny<0 || ny>=n || visited[nx][ny]){
                    continue;
                }
                visited[nx][ny] = true;
                int height = grid[nx][ny];
                pq.offer(new int[] {nx,ny,Math.max(h, height)});
            }
        }
        return -1;
    }
}