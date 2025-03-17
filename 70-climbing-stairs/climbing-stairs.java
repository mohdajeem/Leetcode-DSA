class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return climbRec(n,dp);
    }
    public int climbRec(int step,int[] dp){
        if(step<0) return 0;
        if(step == 0){
            return 1;
        }
        if(dp[step] != -1) return dp[step];
        int oneStep = climbRec(step -1,dp);
        int twoStep = climbRec(step-2,dp);
        return dp[step]=twoStep+oneStep;
    }
}