class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int s = 0, e = n-1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] >= nums[s]){
                 if(target >= nums[s] && target < nums[mid] ){
                    e = mid-1;
                 } else{
                    s = mid+1;
                 }
            } else{
                if(target <= nums[e] && target > nums[mid]){
                    s = mid+1;
                } else{
                    e = mid-1;
                }

            }
        }
        return -1;
    }
}