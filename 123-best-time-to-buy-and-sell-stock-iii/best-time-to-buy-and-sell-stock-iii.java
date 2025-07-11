class Solution {
    int[][][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2][3];
        for(int i= 0;i<n;i++){
            for(int j =0;j<2;j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return rec(0,0,2,prices);
    }
    public int rec(int ind, int buy, int day, int[] prices){
        if(day == 0 || ind == prices.length) return 0;
        
        if(dp[ind][buy][day] != -1) return dp[ind][buy][day];

        int profit = 0;
        if(buy == 0){
            profit = Math.max(-prices[ind]+rec(ind+1, 1, day, prices), rec(ind+1, 0, day, prices));
        }
        if(buy == 1){
            profit = Math.max(prices[ind]+rec(ind+1, 0, day-1, prices), 0+rec(ind+1, 1, day, prices));
        }
        return dp[ind][buy][day]= profit;
    }
}