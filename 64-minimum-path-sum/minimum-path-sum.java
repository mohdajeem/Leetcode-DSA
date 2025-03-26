class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m=grid[0].length;
        // int[][] dp = new int[n][m];
        // for(int[] ar : dp){
        //     Arrays.fill(ar,-1);
        // }
        // return f(n-1,m-1,grid,dp);
        return tabu(grid,n,m);
    }
    public int tabu(int[][] grid, int n, int m){
        int[][] dp = new int[n][m];
        // dp[0][0] = grid[0][0];
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i==0 && j==0) {
                    dp[i][j]=grid[0][0];
                    continue;
                }
                int right = Integer.MAX_VALUE;
                if(j>0) right = grid[i][j] + dp[i][j-1];
                int down = Integer.MAX_VALUE;
                if(i>0) down = grid[i][j] + dp[i-1][j];
                dp[i][j] = Math.min(right,down);
            }
        }
        return dp[n-1][m-1];
    }

    public int f(int i, int j, int[][] grid,int[][] dp){
        // base cases
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[0][0];
        if(dp[i][j] != -1) return dp[i][j];
        // goes up 
        int up = f(i-1,j,grid,dp);
        // goes left;
        int left = f(i,j-1,grid,dp);

        return dp[i][j]=grid[i][j] + Math.min(up,left);
    }
}