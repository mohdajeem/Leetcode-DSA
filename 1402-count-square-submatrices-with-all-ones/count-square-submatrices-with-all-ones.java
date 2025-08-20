class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        int ans = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                ans += rec(i,j,matrix, dp);
            }
        }
        return ans;
    }
    public int rec(int i, int j, int[][] matrix,int[][] dp){
        if(i >= matrix.length || j >= matrix[0].length){
            return 0;
        }
        if(matrix[i][j] == 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int up = rec(i,j+1,matrix, dp);
        int left = rec(i+1,j+1, matrix, dp);
        int side = rec(i+1,j,matrix, dp);

        return dp[i][j] = 1+Math.min(up, Math.min(left, side));
    }
}