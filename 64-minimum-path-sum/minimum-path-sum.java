class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length, m=grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        return f(n-1,m-1,grid,dp);
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