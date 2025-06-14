class Solution {
    public boolean canPartition(int[] nums) {
        int totSum = 0;
        for(int i : nums) totSum+=i;
        if((totSum & 1) == 1) return false;
        int target = totSum/2;
        int n = nums.length;
        // Boolean[][] dp = new Boolean[n][target+1];
        // tabulation
        boolean[][] dp = new boolean[n][target+1];
        for(int i =0;i<n;i++){
            dp[i][0] = true;
        }
        if(nums[0] <= target) dp[0][nums[0]] = true;
        for(int i =1;i<n;i++){
            for(int tar = 1;tar <= target;tar++){
                boolean notTake = dp[i-1][tar];
                boolean take = false;
                if(nums[i] <= tar){
                    take = dp[i-1][tar-nums[i]];
                }
                dp[i][tar] = take || notTake;
            }
        }
        return dp[n-1][target];


        // return rec(n-1, target, nums, dp);
    }
    public boolean rec(int ind, int tar, int[] nums, Boolean[][] dp){
        if(tar == 0) return true;
        if(ind < 0) return false;
        if(dp[ind][tar] != null) return dp[ind][tar];
        boolean notTake = rec(ind-1, tar, nums, dp);
        boolean take = false;
        if(nums[ind] <= tar){
            take = rec(ind-1, tar - nums[ind], nums, dp);
        }
        return dp[ind][tar] = take || notTake;
    }
    
}