class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;
        int s =Integer.MAX_VALUE, e = Integer.MIN_VALUE;
        for(int i : nums){
            s = Math.min(s,i);
            e = Math.max(e,i);
        }
        int ans = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(checkPossible(nums,mid, k)){
                ans = mid;
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        return ans;

    }
    public boolean checkPossible(int[] nums, int mid, int k){
        for(int i = 0;i<nums.length;i++){
            if(nums[i] <= mid){
                k--;
                i++;
            }
            if(k==0) return true;
        }
        return false;
    }
}

// as I see the constraints that nums size may be - 10^9
// so it should be in log n otherwise it will show TLE;
