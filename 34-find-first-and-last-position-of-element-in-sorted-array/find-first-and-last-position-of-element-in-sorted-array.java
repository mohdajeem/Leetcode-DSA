class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[2];
        Arrays.fill(ans,-1);
        int s = 0, e = nums.length-1;
        // find ceil first
        while(s<=e){
            int mid = s  +(e-s)/2;
            if(nums[mid]==target){
                ans[0] = mid;
                e = mid-1;
            } else if(nums[mid]>target){
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        //find floor
        s = 0;
        e=nums.length-1;
        while(s<=e){
            int mid = s +(e-s)/2;
            if(nums[mid]== target){
                ans[1]=mid;
                s = mid+1;
            } else if(nums[mid] < target){
                s = mid+1;
            } else{
                e = mid-1;
            }
        }
        return ans;
        
    }
}