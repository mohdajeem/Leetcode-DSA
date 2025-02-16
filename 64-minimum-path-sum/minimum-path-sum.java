class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return rec(n-1,m-1,grid,dp);
    }
    public int rec(int i, int j, int[][] grid,int[][] dp){
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(i==0 && j==0) return grid[i][j];

        if(dp[i][j] != -1) return dp[i][j];
        int up = Integer.MAX_VALUE;
        if(i>0) up = grid[i][j] + rec(i-1,j,grid,dp);
        int left = Integer.MAX_VALUE;
        if(j>0) left = grid[i][j] + rec(i,j-1,grid,dp);

        return dp[i][j]=Math.min(up,left);
    }
}