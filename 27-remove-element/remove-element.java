class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;
        for(int i = 0;i<nums.length;i++){
            while(nums[i] == val){
                leftShift(nums, i);
                k++;
            }
        }
        return nums.length - k;
    }
    public void leftShift(int[] nums, int ind){
        for(int i = ind;i<nums.length;i++){
            if(i == nums.length-1) nums[i] = -1;
            else nums[i] = nums[i+1];
        }
    }
}