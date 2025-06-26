class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n][n];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return LIC(0,-1,nums);
    }
    public int LIC(int ind, int last, int[] nums){
        if(ind == nums.length){
            return 0;
        }
        if(last != -1 && dp[ind][last] != -1 ) return dp[ind][last];
        int take = 0;
        if(last == -1 || nums[last] < nums[ind]){
            take = 1+LIC(ind+1,ind, nums);
        }
        int notTake = LIC(ind+1,last, nums);
        return last != -1 ? dp[ind][last]=Math.max(take, notTake) : Math.max(take, notTake);
    }
}