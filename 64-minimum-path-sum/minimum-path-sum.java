class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        return solveTab(n,m,grid);
        /*

        int[][] dp = new int[n][m];
        dp[n-1][m-1] = grid[n-1][m-1];
        for(int i = m-2;i>=0;i--){
            dp[n-1][i] = grid[n-1][i] + dp[n-1][i+1];
        }
        for(int i = n-2; i>= 0; i--){
            dp[i][m-1] = grid[i][m-1] + dp[i+1][m-1];
        }

        for(int i = n-2;i>=0;i--){
            for(int j = m-2;j>=0;j--){
                dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[0][0];
        */
    }
    public int solveTab(int n, int m, int[][] arr){
        int[][] dp = new int[n][m];

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(i == 0 && j == 0) dp[i][j] = arr[0][0];
                else {
                    int up = Integer.MAX_VALUE;
                    if(i>0) up = dp[i-1][j];
                    int left = Integer.MAX_VALUE;
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = arr[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[n-1][m-1];
    }
}