class Solution {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int max = 0;
        int[][] dp = new int[k][n];
        for(int [] ar : dp) Arrays.fill(ar,1);
        for(int i = 0;i<n;i++){
            for(int j = 0;j<i;j++){
                int mod = (nums[i]+nums[j])%k;
                dp[mod][i] = Math.max(dp[mod][i], dp[mod][j]+1);
                max = Math.max(dp[mod][i], max);
            }
        }
        
        return max;

    }
}