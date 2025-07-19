class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return rec(0,nums,dp);
    }
    public int rec(int ind, int[] nums,int[] dp){
        if(ind >= nums.length-1) return 0;
        if(nums[ind] == 0) return (int)1e7;
        int take = (int)1e7;
        if(dp[ind] != -1) return dp[ind];
        for(int j=1;j<=nums[ind];j++){
            take = Math.min(take,1+rec(ind+j,nums,dp));
        }
        return dp[ind]=take;
    }
}