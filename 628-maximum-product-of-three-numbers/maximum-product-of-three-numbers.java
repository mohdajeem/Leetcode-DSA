class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = Integer.MIN_VALUE;
        if(nums[0]<0 && nums[1] < 0){
            res = Math.max(res, nums[0]*nums[1]*nums[n-1]);
        }
        res = Math.max(res, nums[n-1]*nums[n-2]*nums[n-3]);
        return res;
    }
}