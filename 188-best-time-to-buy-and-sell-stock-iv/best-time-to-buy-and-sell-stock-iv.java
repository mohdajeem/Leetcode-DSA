class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        return tabulation(n,k,prices);
        // int[][][] dp = new int[n+1][2][k+1];
        // for(int i=0;i<n;i++){
        //     for(int j =0;j<2;j++){
        //         Arrays.fill(dp[i][j], -1);
        //     }
        // }
        // return rec(0,0,k,prices, dp);
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
    public int tabulation(int n, int K, int[] prices){
        int[][][] dp = new int[n+1][2][K+1];

        for(int ind = n-1;ind>=0;ind--){
            for(int buy = 0;buy<=1;buy++){
                for(int k = 1;k<=K;k++){
                    int profit = 0;
                    if(buy == 0){
                        profit = Math.max(-prices[ind]+dp[ind+1][1][k], dp[ind+1][0][k]);
                    }else if(buy == 1){
                        profit = Math.max(prices[ind]+dp[ind+1][0][k-1], dp[ind+1][1][k]);
                    }
                    dp[ind][buy][k] = profit;
                }
            }
        }
        return dp[0][0][K];
    }
}