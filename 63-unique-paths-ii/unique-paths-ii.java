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
        // return useTabluation(m,n,obstacleGrid);
        // return useTabluation2(m,n,obstacleGrid);
    }

    public int useTabluation2(int m, int n, int[][] arr){
        int[][] dp = new int[m][n];
        if(arr[0][0] == 1) return 0;

        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(arr[i][j] == 1) dp[i][j] = 0;
                else if(i == 0 && j == 0) dp[i][j] = 1;
                else{
                    int up = 0;
                    if(i >0) up = dp[i-1][j];
                    int left = 0;
                    if(j>0) left = dp[i][j-1];
                    dp[i][j] = up+left;
                }
                
            }
        }
        return dp[m-1][n-1];
    }


    // using tabuation 
    public int useTabluation(int m, int n, int[][] arr){
        int[][] dp = new int[m][n];
        if(arr[0][0] == 1) return 0;
        dp[0][0] = 1;
        for(int i=1;i<m;i++){
            dp[i][0] = (arr[i][0] == 0 && dp[i-1][0]==1) ? 1 : 0;
        }
        for(int j=1;j<n;j++){
            dp[0][j] = (arr[0][j] == 0 && dp[0][j-1] == 1) ? 1: 0;
        }

        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                if(arr[i][j] != 1){
                    dp[i][j] = dp[i-1][j]+dp[i][j-1];
                } else{
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }

    // using memoization

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