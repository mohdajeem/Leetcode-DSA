class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return f(nums, goal) - f(nums,goal-1);
    }
    public int f(int[] nums, int goal){
        int l = 0, sum = 0;
        int count = 0;
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            while(l<=r && sum > goal){
                sum-= nums[l++];
            }
            count+= (r-l+1);
        }
        System.out.println("goal : "+goal+ ", count : "+count);
        return count;
    }
}