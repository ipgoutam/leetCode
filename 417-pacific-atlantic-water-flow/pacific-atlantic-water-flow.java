class Solution {
    private void dfs(int r, int c, int[][]heights, boolean[][] visited){
        int m = heights.length;
        int n = heights[0].length;

        if(visited[r][c]) return;

        visited[r][c] = true;
        int[][] directions = {
            {1,0}, {-1,0}, {0,1}, {0, -1}
        };
        for(int[] dir : directions){
            int nr = r + dir[0];
            int nc = c + dir[1];

            // out of bounds
            if(nr < 0 || nr >=m || nc < 0 || nc >=n) continue;

            if(heights[nr][nc] >= heights[r][c]){
                dfs(nr, nc, heights, visited);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i=0; i<m; i++){
            dfs(i, 0, heights, pacific);
            dfs(i, n-1, heights, atlantic);
        }
        for(int j=0; j<n; j++){
            dfs(0, j, heights, pacific);
            dfs(m-1, j, heights, atlantic);
        }

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }
}