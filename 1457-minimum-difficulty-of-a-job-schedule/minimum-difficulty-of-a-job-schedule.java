class Solution {
    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        if(n<d) return -1;
        int[][] dp = new int[n+1][d+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return fxn(0,d,jobDifficulty, n, dp);
    }

    public int fxn(int ind, int d, int[] arr, int n, int[][] dp){
        if(d == 1) {
            int max = arr[ind];
            for(int i = ind;i<n;i++){
                max = Math.max(arr[i], max);
            }
            return max;
        }
        if(dp[ind][d] != -1) return dp[ind][d];
        int max = arr[ind];
        int minDiff = Integer.MAX_VALUE;
        for(int i = ind;i<=(n-d);i++){
            max = Math.max(max, arr[i]);
            int res = max + fxn(i+1,d-1,arr,n,dp);
            minDiff = Math.min(minDiff, res);
        }
        return dp[ind][d]=minDiff;
    }

}