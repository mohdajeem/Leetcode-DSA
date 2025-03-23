class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length, m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        return rec(n-1,m-1,obstacleGrid,dp);
    }
    public int rec(int i, int j, int[][] obs,int[][] dp){
        if(i<0 || j<0) return 0;
        if(obs[i][j] == 1) return 0;
        if(i == 0 && j==0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = rec(i-1,j,obs,dp);
        int left = rec(i,j-1,obs,dp);

        return dp[i][j]=up+left;
    }
}