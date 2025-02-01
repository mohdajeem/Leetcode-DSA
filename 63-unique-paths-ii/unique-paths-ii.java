class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        // return useRec(m-1,n-1,obstacleGrid);
        int[][] dp = new int[m][n];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        return useMemo(m-1, n-1, obstacleGrid, dp);
    }
    public int useMemo(int i, int j, int[][] arr, int[][] dp){
        if(i < 0 || j < 0 || arr[i][j] == 1) return 0;
        if(i == 0 && j == 0) return 1;

        if(dp[i][j] != -1) return dp[i][j];
        int up = useMemo(i-1, j, arr, dp);
        int left = useMemo(i, j-1, arr, dp);
        return dp[i][j] = up+left;
    }
    public int useRec(int i, int j, int[][] arr){
        if(i == 0 && j == 0) return 1;
        if(i < 0 || j < 0 || arr[i][j] == 1) return 0;
        int up = useRec(i-1,j,arr);
        int left = useRec(i, j-1,arr);
        return up+left;
    }
}