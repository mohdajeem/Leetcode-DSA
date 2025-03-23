class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] ar: dp){
            Arrays.fill(ar,-1);
        }
        return rec(m-1,n-1,dp);
    }
    public int rec(int i, int j,int[][] dp){
        if(i<0 || j< 0) return 0;
        if(i==0 && j == 0) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        int up = rec(i-1,j,dp);
        int left = rec(i,j-1,dp);

        return dp[i][j]=up+left;
    }
}