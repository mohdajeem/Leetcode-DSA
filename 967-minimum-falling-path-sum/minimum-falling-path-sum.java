class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        // for(int[] ar : dp){
        //     Arrays.fill(ar, -1);
        // }
        // int min = Integer.MAX_VALUE;
        // for(int j = 0;j<m;j++){
        //     min = Math.min(min, f(n-1,j,matrix, dp));
        // }
        // return min;
        return tabulation(matrix);
    }

    public int f(int i, int j, int[][] matrix, int[][] dp){
        if(i<0 || j<0 || j>matrix[0].length-1) return Integer.MAX_VALUE;
        if(i == 0) return matrix[0][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int up = f(i-1,j,matrix,dp);
        int left = f(i-1,j-1,matrix,dp);
        int right = f(i-1, j+1, matrix,dp);
        return dp[i][j]=matrix[i][j] + Math.min(up, Math.min(left, right));
    }
    public int tabulation(int[][] matrix){
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for(int j = 0;j<m;j++){
            dp[0][j] = matrix[0][j];
        }
        for(int i = 1;i<n;i++){
            for(int j = 0;j<m;j++){
                int up = Integer.MAX_VALUE;
                if(i>0) up = dp[i-1][j];
                int left = Integer.MAX_VALUE;
                if(i>0 && j>0) left = dp[i-1][j-1];
                int right = Integer.MAX_VALUE;
                if(j<matrix.length-1) right=dp[i-1][j+1];
                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(left, right));
            }
        }
        int min = Integer.MAX_VALUE;
        for(int j = 0;j<m;j++){
            min = Math.min(min,dp[n-1][j]);
        }
        return min;
    }
}