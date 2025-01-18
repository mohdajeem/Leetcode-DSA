class Solution {
    public int getMaximumGold(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] != 0){
                    ans = Math.max(ans, dfs(i,j,grid));
                }
            }
        }
        return ans;

    }
    public int dfs(int i, int j, int[][] grid){
        if(i < 0 || j<0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) return 0;
        int max = 0, curr = grid[i][j];
        grid[i][j] = 0;
        int[] drow = {0,-1,0,1};
        int[] dcol = {1,0,-1,0};
        for(int z = 0;z<4;z++){
            int nrow = i + drow[z];
            int ncol = j + dcol[z];
            max = Math.max(max,curr+dfs(nrow, ncol, grid));
        }
        grid[i][j] = curr;
        return max;
    }
}
