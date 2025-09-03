class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length, i =0, j =0;
        int res = 0;
        int pro = 1;
        while(j<n){
            pro *= nums[j];
            while(i < j && pro>=k){
                pro /= nums[i++];
            }
            if(pro<k){
                res += (j-i+1);
            }
            j++;
        }
        return res;
    }
}