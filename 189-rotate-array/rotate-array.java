class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        if(n <= 1)  return;
        k = k%n;
        reverse(nums, 0, n-k-1);
        reverse(nums, n-k, n-1);
        reverse(nums, 0, n-1);
    }
    public void reverse(int[] nums, int i, int j){
        while(i<j){
            nums[i] = nums[i]^nums[j];
            nums[j] = nums[i]^nums[j];
            nums[i] = nums[i]^nums[j];
            i++;
            j--;
        }
    }
}