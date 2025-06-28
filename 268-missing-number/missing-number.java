class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int s = 0, e = n-1;
        int ans = n;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(mid != nums[mid]){
                ans = mid;
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        return ans;
    }
}