class Solution {
    public void sortColors(int[] nums) {
        //try using pointers 
        int n = nums.length, mid = 0, low = 0, high = n-1;
        while(mid <= high){
            if(nums[mid] == 0){
                swap(low,mid, nums);
                mid++;
                low++;
            } else if(nums[mid] == 1){
                mid++;
            } else{
                swap(high, mid, nums);
                high--;
            }
        }
    }
    public void swap(int i, int j, int[] nums){
        if(i!=j){
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
        }
    }
}