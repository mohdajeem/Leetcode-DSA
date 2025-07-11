class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        return tabulation(n,prices);
        // int[][] dp = new int[n+1][2];
        // for(int[] ar : dp) Arrays.fill(ar, -1);
        // return rec(0,0,prices, dp);
    }
    public int rec(int ind, int buy, int[] prices, int[][] dp){
        if(ind >= prices.length) return 0;

        if(dp[ind][buy] != -1 ) return dp[ind][buy];
        int op1 = 0;
        int op2 = 0;
        if(buy == 0){
            op1 = -prices[ind]+rec(ind+1, 1, prices, dp);
            op2 = rec(ind+1, 0, prices, dp);
        }
        if(buy == 1){
            op1 = prices[ind]+rec(ind+2, 0, prices, dp);
            op2 = rec(ind+1,1, prices, dp);
        }
        return dp[ind][buy] = Math.max(op1, op2);
    }
    public int tabulation(int n, int[] prices){
        int[][] dp = new int[n+2][2];
        
        for(int ind = n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                int profit = 0;
                if(buy == 0){
                    profit = Math.max(-prices[ind]+dp[ind+1][1], dp[ind+1][0]);
                }
                if(buy == 1){
                    profit = Math.max(prices[ind]+dp[ind+2][0], dp[ind+1][1]);
                }
                dp[ind][buy] = profit;
            }
        }
        return dp[0][0];
    }
}