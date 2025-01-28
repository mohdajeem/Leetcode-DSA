class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i =0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;
        Integer[][] dp = new Integer[nums.length][target+1];

        return subsetSum(nums.length-1,target, nums,dp);

    }
    public boolean subsetSum(int ind, int target, int[] nums, Integer[][] dp){
        if(target == 0) return true;
        if(ind == 0) return nums[0] == target;
        if(dp[ind][target] != null) return dp[ind][target] == 1;
        boolean nonTake = subsetSum(ind-1, target, nums, dp);
        boolean take = false;
        if(nums[ind] <= target) {
            take = subsetSum(ind-1, target-nums[ind],nums,dp);
        }
        dp[ind][target] = (nonTake || take) ? 1 : 0;
        return (nonTake || take);
    }
}