class Solution {
    public int maxProduct(int[] nums) {
        int minPro = nums[0], maxPro = nums[0], ans = nums[0];
        for(int i =1;i<nums.length;i++){
            if(nums[i] < 0){
                int temp = minPro;
                minPro = maxPro;
                maxPro = temp;
            }
            minPro = Math.min(nums[i], nums[i]*minPro);
            maxPro = Math.max(nums[i], nums[i]*maxPro);
            ans = Math.max(ans, maxPro);
        }
        return ans;
    }
}