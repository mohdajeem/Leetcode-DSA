class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int s =0, e = n-1;
        int ans = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                ans = mid;
                return ans;
            } else if(nums[mid] < target){
                s = mid+1;
            } else{
                e = mid-1;
            }
        }
        return ans;
    }
}