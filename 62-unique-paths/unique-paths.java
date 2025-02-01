class Solution {
    public int uniquePaths(int m, int n) {
        // return useRec(m-1,n-1);
        /*
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return useMemo(m-1, n-1, dp);

        */

        // use Tabulation method for optimisation
        return useTab(m,n);
    }
    public int useTab(int m, int n){
        int[][] dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0){
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0;
                if(i > 0) up = dp[i-1][j];
                int left = 0;
                if(j>0) left = dp[i][j-1];
                dp[i][j] = up+left;
            }
        }
        return dp[m-1][n-1];
    }


    public int useMemo(int m, int n, int[][] dp){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;
        
        if(dp[m][n] != -1) return dp[m][n];
        int up = useMemo(m-1, n, dp);
        int left = useMemo(m, n-1, dp);
        return dp[m][n] = up+left;
    }
    public int useRec(int m, int n){
        if(m == 0 && n == 0) return 1;
        if(m < 0 || n < 0) return 0;

        int up = useRec(m-1, n);
        int left = useRec(m,n-1);

        return up + left;
    }
}