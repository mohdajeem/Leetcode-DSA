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
        // return subsetSumEqual(n-1, t, nums, dp);
        return tabulation(nums, n, sum);
        
    }
    public boolean tabulation(int[] nums, int n, int s){
        int t = s/2;
        boolean[][] dp = new boolean[n][t+1];
        // dp[0][nums[0]] = true;
        for(int i = 0;i<n;i++){
            dp[i][0] = true;
        }
        for(int ind = 1;ind<n;ind++){
            for(int  tar = 1;tar<=t;tar++){
                boolean notTake = dp[ind-1][tar];
                boolean take = false;
                if(nums[ind] <= tar){
                    take = dp[ind-1][tar-nums[ind]];
                }
                dp[ind][tar] = take || notTake;
            }
        }
        return dp[n-1][t];
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