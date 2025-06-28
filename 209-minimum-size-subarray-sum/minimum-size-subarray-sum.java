class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int s = 0, e = nums.length;
        int ans = 0;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(windowFind(mid,nums, target)){
                ans = mid;
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        return ans;
    }
    public boolean windowFind(int size, int[] nums, int tar){
        int sum = 0;
        int l = 0, r = 0, n = nums.length;
        while(r < size){
            sum += nums[r++];
        }
        if(sum >= tar) return true;
        while(r<n){
            sum+=nums[r];
            sum -= nums[l];
            r++;
            l++;
            if(sum >= tar) return true;
        }
        return false;
    }
}