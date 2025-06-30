class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int l = 0, r = 0;
        int ans = 0;
        while(r<n){
            while(nums[r]-nums[l] > 1){
                l++;
            }
            if(nums[r] - nums[l] == 1) ans = Math.max(ans, r-l+1);
            r++;
        }
        return ans;
    }
}