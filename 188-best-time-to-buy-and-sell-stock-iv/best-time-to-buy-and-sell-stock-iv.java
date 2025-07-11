class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][k+1];
        for(int i=0;i<n;i++){
            for(int j =0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return rec(0,0,k,prices, dp);
    }
    public int rec(int ind, int buy, int k, int[] prices, int[][][] dp){
        if(k == 0 || ind == prices.length) return 0;

        if(dp[ind][buy][k] != -1) return dp[ind][buy][k];
        int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[ind]+rec(ind+1, 1, k, prices, dp), rec(ind+1, 0, k, prices, dp));
        }
        if(buy == 1){
            profit = Math.max(prices[ind]+rec(ind+1, 0, k-1, prices, dp), rec(ind+1, 1, k, prices, dp));
        }
        return dp[ind][buy][k]= profit;
    }
}