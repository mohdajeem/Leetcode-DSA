class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return fxn(0, 0, prices, dp);
    }

    public int fxn(int ind, int buy, int[] prices, int[][] dp){
        if(ind == prices.length) return 0;
        if(dp[ind][buy] != -1) return dp[ind][buy];
        int op1 = 0, op2 = 0;
        if(buy == 0){
            op1 = 0+fxn(ind+1,0,prices, dp);
            op2 = -prices[ind]+fxn(ind+1,1,prices, dp);
        }
        
        if(buy == 1){
            op1 = fxn(ind+1, 1, prices, dp);
            op2 = prices[ind]+fxn(ind+1, 0,prices, dp);
        }
        return dp[ind][buy] = Math.max(op1, op2);
    }
}