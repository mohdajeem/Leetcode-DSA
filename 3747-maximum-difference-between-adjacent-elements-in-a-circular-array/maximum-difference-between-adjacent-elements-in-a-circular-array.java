class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            int absDiff = Math.abs(nums[i%n]-nums[(i+1)%n]);
            max = Math.max(max, absDiff);
        }
        return max;
    }
}