class Solution {
    public int minFallingPathSum(int[][] matrix) {
        /*
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0;j<m;j++){
            ans = Math.min(ans, solveRec(n-1, j,matrix, dp));
        }
        return ans;

        gives us TLE
        */

        // use TAbulation
        return solveTabu(matrix);
    }

    public int solveTabu(int[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        int[][] dp = new int[n][m];
        
        // base case 
        for(int j = 0;j<m;j++) dp[0][j] = arr[0][j];
        for(int i = 1;i<n;i++){
            for(int j = 0;j<m;j++){
                // copy paste rec
                int down = dp[i-1][j];
                int left = Integer.MAX_VALUE;
                if(j < m-1) left = dp[i-1][j+1];
                int right = Integer.MAX_VALUE;
                if(j > 0) right = dp[i-1][j-1];

                dp[i][j] = arr[i][j] + Math.min(down, Math.min(left, right));
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int j = 0;j<m;j++){
            ans = Math.min(ans, dp[n-1][j]);
        }
        return ans;
    }

    public int solveRec(int i, int j, int[][] matrix, int[][] dp){

        // base case 
        if(j < 0 || j > matrix.length -1 || i < 0) return Integer.MAX_VALUE;
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != -1) return dp[i][j];
        int up = solveRec(i-1, j,matrix, dp);
        int left = solveRec(i-1, j-1, matrix, dp);
        int right = solveRec(i-1, j+1, matrix, dp);

        return dp[i][j] =  matrix[i][j] + Math.min(up, Math.min(left, right));
    }
}