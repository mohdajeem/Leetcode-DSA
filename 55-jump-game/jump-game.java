class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        return canJumpRec(0,nums,dp);
    }
    public boolean canJumpRec(int ind, int[] nums, Boolean[] dp){
        if(ind >= nums.length-1){
            return true;
        }
        if(nums[ind] == 0) return false;
        if(dp[ind] != null) return dp[ind];
        boolean res = false;
        for(int i = 1;i<=nums[ind];i++){
            res = res || canJumpRec(ind+i,nums,dp);
        }
        return dp[ind]=res;

    }
}