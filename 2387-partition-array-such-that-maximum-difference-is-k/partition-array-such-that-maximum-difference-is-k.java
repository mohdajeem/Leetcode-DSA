class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        int r=0;
        while(r < n){
            int min = nums[r];
            while(r<n && nums[r]-min <= k){
                r++;
            }
            ans++;
        }
        return ans;
    }
}