class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans = 1;
        int l = 0, r = 0, n = nums.length;
        int bitmask = 0; // perform or operations of the window
        while(r<n){
            while(l<n && (bitmask & nums[r])!=0){
                bitmask^=nums[l];
                l++;
            }
            bitmask |= nums[r];
            ans = Math.max(ans,r-l+1);
            r++;
        }
        return ans;
    }
}