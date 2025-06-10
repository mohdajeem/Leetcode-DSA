class Solution {
    public int longestOnes(int[] nums, int k) {
        int sum =0;
        int l = 0, r = 0, n = nums.length, c =0;
        int max = 0;
        while(r<n){
            sum++;
            if(nums[r]==0){
                c++;
            }
            while(l<=r && c > k){
                if(nums[l]==0) c--;
                sum--;
                l++;
            }
            r++;
            max = Math.max(sum, max);
        }
        return max;
    }
}