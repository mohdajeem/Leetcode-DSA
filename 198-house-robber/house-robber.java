class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return rec(n-1,nums,dp);
    }
    public int rec(int ind, int[] nums,int[] dp){
        if(ind == 0){
            return nums[ind];
        }
        if(dp[ind] != -1) return dp[ind];

        int notTake = rec(ind-1,nums,dp);
        int take = nums[ind];
        if(ind > 1){
            take = nums[ind] + rec(ind-2,nums,dp);
        }
        return dp[ind] =  Math.max(notTake, take);
    }
}