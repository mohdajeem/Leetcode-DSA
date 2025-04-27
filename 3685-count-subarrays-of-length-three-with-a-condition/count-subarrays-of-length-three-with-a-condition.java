class Solution {
    public int countSubarrays(int[] nums) {
        int ans = 0, n = nums.length;
        int l = 0, m = 1, r = 2;
        while(r<n){
            if(2*(nums[l]+nums[r]) == nums[m]){
                ans++;
            }
            l++;
            r++;
            m++;
        }
        return ans;
    }
}