class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int break_point = 0;
        for(int i =0;i<n-1;i++){
            if(nums[i]>nums[i+1]){
                break_point = i+1;
                break;
            }
        }
        int ans = -1;
        System.out.println(break_point);
        if(target <= nums[n-1]){
            // our target would from break_point to end;
            System.out.println("inside t<nums[n-1]");
            int s = break_point;
            int e = n-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(nums[mid] == target){
                    return mid;
                } else if(nums[mid] > target){
                    e = mid-1;
                } else{
                    s = mid+1;
                }
            }
        } else{
            System.out.println("Else functioon");
            int s = 0;
            int e = break_point-1;
            while(s<=e){
                int mid = s+(e-s)/2;
                if(nums[mid] == target){
                    return mid;
                } else if(nums[mid]>target){
                    e = mid-1;
                } else{
                    s = mid+1;
                }
            }
        }

        return ans;
    }
}