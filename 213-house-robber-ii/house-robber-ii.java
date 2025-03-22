class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        if(n==2) return Math.max(nums[0],nums[1]);
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        return Math.max(rec(n-1,1,nums,dp1),rec(n-2,0,nums,dp2));
    }
    public int rec(int ind, int startInd, int[] nums,int[] dp){
        if(ind == startInd) return nums[startInd];
        if(ind < startInd) return 0;
        if(dp[ind] != -1) return dp[ind];
        int notTake = rec(ind-1,startInd, nums,dp);
        int take = nums[ind] + rec(ind-2, startInd, nums,dp);

        return dp[ind]= Math.max(take,  notTake);
    }
}