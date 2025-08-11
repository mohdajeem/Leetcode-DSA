class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return helper(nums, goal)-helper(nums, goal-1);
    }
    public int helper(int[] nums, int goal){
        int n = nums.length, l =0, r=0, sum =0;
        int res = 0;
        while(r < n){
            sum+=nums[r];
            while(l <= r && sum > goal){
                sum -= nums[l];
                l++;
            }
            res += (r-l+1);
            r++;
        }
        return res;
    }
}