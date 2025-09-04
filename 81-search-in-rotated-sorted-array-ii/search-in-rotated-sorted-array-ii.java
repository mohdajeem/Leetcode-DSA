class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length, low = 0, high = n-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            if(nums[mid] == target) return true;
            if(nums[mid] == nums[low] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }
            if(nums[mid] >= nums[low]){
                if(target >= nums[low] && target < nums[mid]){
                    high = mid-1;
                } else{
                    low = mid+1;
                }
            } else{
                if(target <= nums[high] && target >= nums[mid]){
                    low = mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        return false;
    }
}