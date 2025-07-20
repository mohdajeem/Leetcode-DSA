class Solution {
    public int jump(int[] nums) {
        int[] dp =  new int[nums.length];
        Arrays.fill(dp,-1);
        return rec(0, nums, dp);
    }
    public int rec(int ind, int[] nums, int[] dp){
        if(ind >= nums.length-1) return 0;
        if(dp[ind] != -1) return dp[ind];
        if(nums[ind] == 0) return (int)1e9;
        int min = (int)1e9;
        for(int i = 1;i<=nums[ind];i++){
            min = Math.min(min, 1+rec(ind+i, nums, dp));
        }
        return dp[ind] = min;
    }
}