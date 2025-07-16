class Solution {
    int[][] dp;
    public int maximumLength(int[] nums) {
        int n = nums.length;
        // int l = 0, r = 1;
        // int ans = 0;
        // while(r < n){
        //     int v1 = (nums[l]+nums[l+1])%2;
        //     int v2 = (nums[r]+nums[r-1])%2;
        //     if(v1 != v2){
        //         l++;
        //     }
        //     ans = Math.max(r-l+1, ans);
        //     r++;
        // }
        // return ans;
        int ans = 0;
        dp = new int[n][4];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        for(int i = 0;i<4;i++){
            ans = Math.max(ans, rec(0,i,nums));
        }
        return ans;
    }
    public int rec(int i,int par, int[] nums){
        if(i == nums.length) return 0;
        int take = 0;
        int notTake = 0;
        if(dp[i][par] != -1) return dp[i][par];
        if(par == 0){
            // even elem
            if(nums[i]%2 == 0){
                take = 1 + rec(i+1,par, nums);
            } else{
                notTake = rec(i+1, par, nums);
            }
        } else if(par == 1){
            if(nums[i]%2 != 0){
                take = 1 + rec(i+1, par, nums);
            } else{
                notTake = rec(i+1, par, nums);
            }
        } else if(par == 2){
            if(nums[i]%2 == 0){
                take = 1 + rec(i+1, 3, nums);
            } else{
                notTake = rec(i+1, par, nums);
            }
        } else{
            if(nums[i]%2 != 0){
                take = 1 + rec(i+1,2, nums);
            } else{
                notTake = rec(i+1, par, nums);
            }
        }
        return dp[i][par] = Math.max(take, notTake);
    }
}