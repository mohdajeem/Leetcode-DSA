class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        int ans = f(n-1, amount, coins,dp);
        return  ans== (int) 1e7 ? -1 : ans;
        
    }
    public int f(int ind, int amount, int[] coins,int[][] dp){
        if(amount == 0) return 0;
        if(ind<0 || amount < 0) return (int)1e7;
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int notTake = f(ind-1, amount, coins,dp);
        int take = (int)1e7;
        if(amount >= coins[ind]){
            take = 1+f(ind, amount-coins[ind], coins,dp);
        }

        return dp[ind][amount]=Math.min(notTake, take);
    }
}