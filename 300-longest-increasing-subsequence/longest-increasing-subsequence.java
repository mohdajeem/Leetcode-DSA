class Solution {
    int[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new int[n+1][n+1];
        for(int i = n-1;i>=0;i--){
            for(int last = n-1;last >= -1;last--){
                int notTake = dp[i+1][last+1];
                int take = 0;
                if(last == -1 || nums[last] < nums[i]){
                    take = 1 + dp[i+1][i+1];
                }
                dp[i][last+1] = Math.max(take, notTake);
            }
        }
        return dp[0][0];
    }
}