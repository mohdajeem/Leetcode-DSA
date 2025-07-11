class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] ar : dp)  Arrays.fill(ar, -1);
        return rec(0,0,prices,dp);
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
}