class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0],nums[1]);
        int[] dp1 = new int[n]; 
        Arrays.fill(dp1,-1);
        int ans1 = solve(n-1,nums,1,dp1);
        Arrays.fill(dp1,-1);
        int ans2 = solve(n-2,nums,0,dp1);
        return Math.max(ans1, ans2);
    }

    public int solve(int ind, int[] nums, int start,int[] dp1){
        if(ind == start) return nums[start];
        if(ind < start) return 0;
        if(dp1[ind] != -1) return dp1[ind];
        int lh = nums[ind] + solve(ind-2, nums, start, dp1);
        int rh = solve(ind-1, nums,start, dp1);

        return dp1[ind] = Math.max(lh,rh);
    }
}