class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return tabu(n,prices);
        // int[][] dp = new int[n][2];
        // for(int[] ar : dp)  Arrays.fill(ar, -1);
        // return rec(0,0,prices,dp);
    }
    public int rec(int ind, int buy, int[] prices, int[][] dp){
        if(ind == prices.length) return 0;

        if(dp[ind][buy] != -1) return dp[ind][buy];

        int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[ind]+rec(ind+1,1,prices,dp), 0+rec(ind+1, 0, prices,dp));
        }
        if(buy == 1){
            profit = Math.max(prices[ind]+rec(ind+1, 0, prices,dp), 0+rec(ind+1, 1, prices,dp));
        }
        return dp[ind][buy] = profit;

    }
    public int tabu(int n, int[] prices){
        int[][] dp = new int[n+1][2];

        for(int i = n-1;i>=0;i--){
            for(int j = 0;j<=1;j++){
                int profit = 0;
                if(j == 0){
                    profit = Math.max(-prices[i]+dp[i+1][1], 0+dp[i+1][0]);
                }
                if(j == 1){
                    profit = Math.max(prices[i]+dp[i+1][0], 0+dp[i+1][1]);
                }
                dp[i][j] = profit;
            }
        }
        return dp[0][0];
    }
}