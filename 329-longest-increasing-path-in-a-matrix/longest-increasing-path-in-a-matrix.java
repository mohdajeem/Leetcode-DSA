class Solution {
    int[] drow = {0,-1,0,1};
    int[] dcol = {1,0,-1,0};
    int[][] dp;
    public int longestIncreasingPath(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int ans = 0;
        dp= new int[n][m];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                ans = Math.max(ans, rec(i,j, matrix));
            }
        }
        return ans;

    }
    public int rec(int i, int j, int[][] matrix){
        if(dp[i][j] != -1) return dp[i][j];
        int max = 1;
        for(int k =0;k<4;k++){
            int nrow=i+drow[k];
            int ncol = j+dcol[k];
            if(isValid(nrow, ncol, matrix) && matrix[nrow][ncol] > matrix[i][j]){
                max = Math.max(max,1+rec(nrow, ncol, matrix));
            }
        }
        return dp[i][j]=max;
    }
    public boolean isValid(int i, int j, int[][] matrix){
        return i >= 0 && j>=0 && i<matrix.length && j < matrix[0].length;
    }
}