class Solution {
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int[] ans = new int[1];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 1){
                    dfs(i,j, ans, vis,grid);
                    return ans[0];
                }
            }
        }
        return 0;

    }
    public void dfs(int sr, int sc, int[] ans, boolean[][] vis, int[][] grid){
        // count zeros or out of bound
        if(sr < 0 || sr>=grid.length || sc <0 || sc >= grid[0].length || grid[sr][sc] == 0){
                ans[0]++;
                return;
        }
        if(vis[sr][sc]) return;
        vis[sr][sc] = true;
        int[] drow = {0,-1,0,1};
        int[] dcol = {1,0,-1,0};
        for(int i =0;i<4;i++){
            int nrow = sr+drow[i];
            int ncol = sc+dcol[i];
            dfs(nrow, ncol, ans,vis,grid);
        }
    }
}