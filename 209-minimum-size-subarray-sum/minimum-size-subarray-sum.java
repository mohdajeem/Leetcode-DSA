class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length, i =0, j=0, sum =0;
        int min = Integer.MAX_VALUE;
        while(j < n){
            sum += nums[j];
            while(i <= j && sum >= target){
                min = Math.min(min, j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}