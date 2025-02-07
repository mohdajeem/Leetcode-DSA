class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2 != 0) return false;
        // return subsetSumEqual(n-1, sum/2, nums);
        // Now we will do memoization in this function
        int t = sum/2;
        int[][] dp = new int[n][t+1];
        for(int[] ar: dp) Arrays.fill(ar,-1);
        return subsetSumEqual(n-1, t, nums, dp);
        
    }

    public boolean subsetSumEqual(int ind, int t, int[] nums,int[][] dp){

        // base Case 
        if(ind == 0){
            return t == nums[ind];
        }
        if(t==0) return true;
        if(dp[ind][t] != -1) return dp[ind][t] == 1;
        boolean notTake = subsetSumEqual(ind-1, t, nums,dp);
        boolean take = false;
        if(nums[ind] <= t){
            take = subsetSumEqual(ind-1, t-nums[ind], nums,dp);
        }
        dp[ind][t] = (take||notTake) ? 1 : 0;
        return take || notTake;
    }
}