class Solution {
    int n=0;
    int m=0;
    public int dfs(int[][] grid, int i, int j){
        //out of bound
        if(i<0 || i >= n || j<0 || j>= m){
            return 0;
        }
        // water or visited
        if(grid[i][j]  == 0 || grid[i][j] == 2){
            return 0;
        }
        grid[i][j] = 2;
        int area=1;
        area += dfs(grid, i-1, j);
        area += dfs(grid, i, j+1);
        area += dfs(grid, i+1, j);
        area += dfs(grid, i, j-1);
        return area;
    }
    public int maxAreaOfIsland(int[][] grid){
        n = grid.length;
        m = grid[0].length;
        int maxArea=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == 1){
                    int totalArea = dfs(grid, i, j);
                    if(totalArea > maxArea){
                        maxArea = totalArea;
                    }
                }
            }
        }
        return maxArea;
    }
}