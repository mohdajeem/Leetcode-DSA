class Solution {
    public int uniquePaths(int m, int n) {
        // return useRec(m-1,n-1);
        int[][] dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return useMemo(m-1, n-1, dp);
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