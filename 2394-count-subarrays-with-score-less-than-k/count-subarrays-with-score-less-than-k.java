class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        long count = 0, sum = 0;
        int l=0,r=0;
        while(r<n) {
            sum += nums[r];
            while(l<= r && sum*(r-l+1) >= k){
                sum-=nums[l++];
            }
            count += (r-l+1);
            r++;
        }
        return count;
    }
}