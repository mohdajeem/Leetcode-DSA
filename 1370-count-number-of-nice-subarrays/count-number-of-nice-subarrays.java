class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i =0;i<n;i++){
            if((nums[i]&1) == 0){
                nums[i]=0;
            } else{
                nums[i]=1;
            }
        }
        return fxn(nums,n, k) - fxn(nums, n, k-1);
    }
    public int fxn(int[] nums, int n, int k){
        int l = 0, sum =0, count =0;
        for(int r=0;r<n;r++){
            sum+=nums[r];
            while(sum > k && l<=r){
                sum-=nums[l++];
            }
            count+=(r-l+1);
        }
        return count;
    }
}